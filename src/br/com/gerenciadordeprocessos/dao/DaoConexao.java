package br.com.gerenciadordeprocessos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoConexao {
    public static Connection getConexao() {
        final String tirarWarning = "?useSSL=false";
        final String banco = "BdGerenciadorDeProcessos";
        String url = "jdbc:mysql://localhost:3306/" + banco + tirarWarning;
        String user = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            Logger.getLogger(DaoConexao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
