package bank.omnibank.api.dao;

import bank.omnibank.api.factory.ConnectionFactory;
import bank.omnibank.api.model.Cliente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClienteDao {
    ConnectionFactory connectionFactory;

    public ClienteDao(Connection con) {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastrarCliente(Cliente cliente) {
        connectionFactory.abrirConexaoBD();

        String sql = "{call spCadastrarCliente(?, ?, ?, ?)}";

        try {
            // Criamos a variavel de conexao que irá receber a classe de abrir conexao com banco de dados
            Connection con = connectionFactory.abrirConexaoBD();
            // Prepara para enviar a query
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, cliente.getNome());
            cs.setString(2, cliente.getCpf());
            cs.setString(3, cliente.getEmail());
            cs.setString(4, cliente.getTelefone());
            cs.execute();
            cs.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }


}
