package com.miapp.infrastructure.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexionBD {
    Connection getConexion() throws SQLException;
}
