package br.com.omnibank.factory;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection abrirConexaoBD() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/omnibank", "root", "toophotel12");

        } catch(SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }

    }
}
