package br.com.omnibank.dao;

import br.com.omnibank.factory.ConnectionFactory;
import br.com.omnibank.model.Cartao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CartaoDao {
    ConnectionFactory connectionFactory;

    public CartaoDao(Connection conn) {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastrarCartao(int idCliente, BigDecimal limite) {

        connectionFactory.abrirConexaoBD();

        String sql = "{call spCadastrarCartao(?, ?)}";

        try {
            // Criamos a variavel de conexao que irá receber a classe de abrir conexao com banco de dados
            Connection con = connectionFactory.abrirConexaoBD();
            // Prepara para enviar a query
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, idCliente);
            cs.setBigDecimal(2, limite);
            cs.execute();
            cs.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }

    public void alterarStatusCartao(int idCliente, int idCartao, String statusCartao) {
        connectionFactory.abrirConexaoBD();

        String sql = "{call spStatusCartao(?, ?, ?)}";

        try {
            Connection con = connectionFactory.abrirConexaoBD();

            CallableStatement callableStatement = con.prepareCall(sql);
            callableStatement.setInt(1, idCliente);
            callableStatement.setInt(2, idCartao);
            callableStatement.setString(3, statusCartao);
            callableStatement.execute();
            callableStatement.close();
            con.close();

        }
        catch(SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }

    }
}
