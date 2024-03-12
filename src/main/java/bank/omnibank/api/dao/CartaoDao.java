package bank.omnibank.api.dao;

import bank.omnibank.api.dados.cartao.DadosCadastroCartao;
import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.factory.ConnectionFactory;
import bank.omnibank.api.model.Cartao;

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

    public void cadastrarCartao(Long idCliente, BigDecimal limite) {

        connectionFactory.abrirConexaoBD();

        String sql = "{call spCadastrarCartao(?, ?)}";

        try {
            // Criamos a variavel de conexao que irá receber a classe de abrir conexao com banco de dados
            Connection con = connectionFactory.abrirConexaoBD();
            // Prepara para enviar a query
            CallableStatement cs = con.prepareCall(sql);
            cs.setLong(1, idCliente);
            cs.setBigDecimal(2, limite);
            cs.execute();
            cs.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }

    public List<DadosListagemCartao> listarCliente() {
        List<DadosListagemCartao> cartoes = new ArrayList<>();

        String sql = "{call spListarCartoes()}";

        try {
            // Criamos a variavel de conexao que irá receber a classe de abrir conexao com banco de dados
            Connection con = connectionFactory.abrirConexaoBD();
            // Prepara para enviar a query
            CallableStatement callableStatement = con.prepareCall(sql);
            ResultSet result = callableStatement.executeQuery();

            while (result.next()) {
                String numeroCartao = result.getString(1);
                String nomeCliente = result.getString(2);
                BigDecimal limiteCartao = result.getBigDecimal(3);
                String dataValidade = result.getString(4);
                DadosListagemCartao dadosCartao = new DadosListagemCartao(numeroCartao, nomeCliente, limiteCartao, dataValidade);

                cartoes.add(dadosCartao);

            }
            result.close();
            callableStatement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
        return cartoes;
    }
    public void alterarStatusCartao(Long idCliente, int idCartao, String statusCartao) {
        connectionFactory.abrirConexaoBD();

        String sql = "{call spStatusCartao(?, ?, ?)}";

        try {
            Connection con = connectionFactory.abrirConexaoBD();

            CallableStatement callableStatement = con.prepareCall(sql);
            callableStatement.setLong(1, idCliente);
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
