package com.miapp.infrastructure.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.miapp.domain.entity.Cliente;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.infrastructure.database.ConexionBD;

public class ClienteRepositorioMySQL implements ClientRespository {
    private final ConexionBD connection;
    
    public ClienteRepositorioMySQL(ConexionBD connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Cliente cliente) {
        String sql = "INSERT INTO clientes (id, nombre, email) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}