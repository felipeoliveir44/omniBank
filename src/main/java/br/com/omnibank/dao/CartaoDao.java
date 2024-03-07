package br.com.omnibank.dao;

import br.com.omnibank.factory.ConnectionFactory;
import br.com.omnibank.model.Cartao;
import br.com.omnibank.model.Cliente;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

    public List<Cartao> listarCartoesPorCliente(String p) {
        List<Cartao> cartoes = new ArrayList<>();
        Cliente cliente = new Cliente();

        try {
            Connection con = connectionFactory.abrirConexaoBD();
            String sql = "{call spListarCartoes(?)}";
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, p);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                String numeroCartao = rs.getString(1);
                String nomeCliente = rs.getString(2);
                BigDecimal limite = rs.getBigDecimal(3);
                String validade = rs.getString(4);
                Cartao cartao = new Cartao(numeroCartao, nomeCliente, validade, limite);
                cartoes.add(cartao);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
        return cartoes;
    }

}
