package bank.omnibank.api.service;

import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.dao.CartaoDao;
import bank.omnibank.api.dao.ClienteDao;
import bank.omnibank.api.factory.ConnectionFactory;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Cliente;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

    private Cliente cliente;
    private ConnectionFactory connectionFactory;

    public CartaoService() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastrarCartao(Long idCliente, BigDecimal limite) {
        CartaoDao cartaoDao = new CartaoDao(connectionFactory.abrirConexaoBD());
        cartaoDao.cadastrarCartao(idCliente, limite);
    }

    public List<DadosListagemCartao> listarClientesService() {
        CartaoDao cartaoDao = new CartaoDao(connectionFactory.abrirConexaoBD());
        return cartaoDao.listarCliente();
    }
    public void alterarStatusCartao(Long idCliente, int idCartao, String statusCartao) {
        CartaoDao cartaoDao = new CartaoDao(connectionFactory.abrirConexaoBD());
        cartaoDao.alterarStatusCartao(idCliente, idCartao, statusCartao);
    }
}
