package com.miapp.domain.repository;

import java.util.List;

import com.miapp.domain.entity.Cliente;

public interface ClientRespository {
    void guardar(Cliente cliente);
    Cliente buscarPorId(int id);
    List<Cliente> listarTodos();
    void actualizar(Cliente cliente);
    void eliminar(int id);
}
