package com.miapp.domain.repository;

import java.util.List;

import com.miapp.domain.entity.Client;

public interface ClientRespository {
    void guardar(Client cliente);
    Client buscarPorId(int idBuscar);
    List<Client> listarTodos();
    void actualizar(Client cliente);
    void eliminar(int id);
}