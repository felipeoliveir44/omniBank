package br.com.omnibank.dao;

import br.com.omnibank.factory.ConnectionFactory;
import br.com.omnibank.model.Cartao;

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

            // Prepara para enviar a query
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

    public List<Cartao> listarCartoesPorCliente(int idCliente) {
        Connection con = null;
        List<Cartao> cartoes = new ArrayList<>();

        try {
            con = connectionFactory.abrirConexaoBD();
            String sql = "SELECT * FROM cartao WHERE id_cliente = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idCliente);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        BigDecimal limite = rs.getBigDecimal("limite");

                        // Certifique-se de ajustar o construtor da classe Cartao conforme necessário
                        Cartao cartao = new Cartao(id, idCliente, limite);
                        cartoes.add(cartao);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        } finally {
            connectionFactory.fecharConexaoBD(con);
        }

        return cartoes;
    }
}
