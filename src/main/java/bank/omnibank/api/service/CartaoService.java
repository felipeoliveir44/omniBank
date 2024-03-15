package bank.omnibank.api.service;

import bank.omnibank.api.dados.cartao.DadosAtualizacaoCartao;
import bank.omnibank.api.dados.cartao.DadosAtualizacaoLimite;
import bank.omnibank.api.dados.cartao.DadosCadastroCartao;
import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.dados.cliente.DadosListagemCliente;
import bank.omnibank.api.dao.CartaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    @Autowired
    private CartaoDao cartaoDao;

    public void cadastrarCartao(DadosCadastroCartao dados) {
        cartaoDao.cadastrarCartao(new DadosCadastroCartao(dados.id(), dados.limite()));
    }

    public Page<DadosListagemCartao> listarClientes(Pageable paginacao) {
        return cartaoDao.listarCartao(paginacao);
    }

    public void alterarStatus(DadosAtualizacaoCartao dados) {
        cartaoDao.atualizarStatus(dados);
    }

    public void atualizarLimite(DadosAtualizacaoLimite dados){
        cartaoDao.atualizarLimite(dados);
    }


}

