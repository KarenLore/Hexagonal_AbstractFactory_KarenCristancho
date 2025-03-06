package com.miapp.infrastructure.database;

public class ConexionFactory {
    public static ConexionBD crearConexion() {
        return new ConexionMySQL();
    }
}
