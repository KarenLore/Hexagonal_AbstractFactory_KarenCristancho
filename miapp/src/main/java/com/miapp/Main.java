package com.miapp;

import com.miapp.aplication.usecase.ClienteCasoUso;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.infrastructure.database.ConexionFactory;
import com.miapp.infrastructure.persistence.ClienteRepositorioMySQL;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new ClienteRepositorioMySQL(ConexionFactory.crearConexion());
        ClienteCasoUso clienteCasoUso = new ClienteCasoUso(repositorio);
    }
}
