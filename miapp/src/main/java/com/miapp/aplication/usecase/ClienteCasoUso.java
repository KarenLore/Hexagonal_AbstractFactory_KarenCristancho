package com.miapp.aplication.usecase;

import java.util.List;

import com.miapp.domain.entity.Cliente;
import com.miapp.domain.repository.ClientRespository;

public class ClienteCasoUso {
    private final ClientRespository repository;

    public ClienteCasoUso(ClientRespository repository) {
        this.repository = repository;
    }

    public void registrarCliente(int id, String nombre, String email) {
        Cliente cliente = new Cliente(id, nombre, email);
        repository.guardar(cliente);
    }

    public Cliente obtenerCliente(int id) {
        return repository.buscarPorId(id);
    }

    public List<Cliente> listarClientes() {
        return repository.listarTodos();
    }

    public void actualizarCliente(int id, String nombre, String email) {
        Cliente cliente = new Cliente(id, nombre, email);
        repository.actualizar(cliente);
    }

    public void eliminarCliente(int id) {
        repository.eliminar(id);
    }
}
