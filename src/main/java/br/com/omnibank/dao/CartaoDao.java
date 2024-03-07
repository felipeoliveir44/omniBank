package br.com.omnibank.dao;

import br.com.omnibank.factory.ConnectionFactory;
import br.com.omnibank.model.Cartao;
import br.com.omnibank.model.Cliente;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaoDao {
    private ConnectionFactory connectionFactory;

    public CartaoDao(Connection conn) {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastrarCartao(int idCliente, BigDecimal limite) {
        Connection con = null;

        try {
            con = connectionFactory.abrirConexaoBD();
            String sql = "{call spCadastrarCartao(?, ?)}";

            try (CallableStatement cs = con.prepareCall(sql)) {
                cs.setInt(1, idCliente);
                cs.setBigDecimal(2, limite);
                cs.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        } finally {
            connectionFactory.fecharConexaoBD(con);
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
                Cartao cartao = new Cartao(numeroCartao, nomeCliente, validade,limite);
                cartoes.add(cartao);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
        return cartoes;
    }
}
