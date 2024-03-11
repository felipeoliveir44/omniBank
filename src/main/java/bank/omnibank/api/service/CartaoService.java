package bank.omnibank.api.service;

import bank.omnibank.api.dao.CartaoDao;
import bank.omnibank.api.dao.ClienteDao;
import bank.omnibank.api.factory.ConnectionFactory;
import bank.omnibank.api.model.Cliente;

import java.math.BigDecimal;

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

    public void alterarStatusCartao(int idCliente, int idCartao, String statusCartao) {
        CartaoDao cartaoDao = new CartaoDao(connectionFactory.abrirConexaoBD());
        cartaoDao.alterarStatusCartao(idCliente, idCartao, statusCartao);
    }
}
