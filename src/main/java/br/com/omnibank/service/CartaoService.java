package br.com.omnibank.service;

import br.com.omnibank.dao.CartaoDao;
import br.com.omnibank.dao.ClienteDao;
import br.com.omnibank.factory.ConnectionFactory;
import br.com.omnibank.model.Cartao;
import br.com.omnibank.model.Cliente;

import java.math.BigDecimal;
import java.util.List;

public class CartaoService {
    private Cliente cliente;
    private ConnectionFactory connectionFactory;

    public CartaoService() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastrarCartao(int idCliente, BigDecimal limite) {
        CartaoDao cartaoDao = new CartaoDao(connectionFactory.abrirConexaoBD());
        cartaoDao.cadastrarCartao(idCliente, limite);
    }

    public List<Cartao> listarCartoesPorCliente(String p) {
        CartaoDao cartaoDao = new CartaoDao(connectionFactory.abrirConexaoBD());
        return cartaoDao.listarCartoesPorCliente(p);
    }
}
