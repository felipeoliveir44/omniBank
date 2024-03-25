package bank.omnibank.api.service;

import bank.omnibank.api.dados.cartao.*;
import bank.omnibank.api.dados.cliente.DadosListagemCliente;
import bank.omnibank.api.dao.CartaoDao;
import bank.omnibank.api.model.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoDao cartaoDao;

    public void cadastrarCartao(DadosCadastroCartao dados) {
        cartaoDao.cadastrarCartao(new DadosCadastroCartao(dados.id(), dados.limite()));
    }

    public Page<DadosListagemCartao> listarCartao(Pageable paginacao) {
        return cartaoDao.listarCartao(paginacao);
    }

    public Page<DadosEncontrarPeloCpf> listarCartaoCpf(String cpf, Pageable paginacao) {
        return cartaoDao.listarCartaoCpf(cpf, paginacao);
    }

    public void alterarStatus(DadosAtualizacaoCartao dados) {
        cartaoDao.atualizarStatus(dados);
    }

    public void atualizarLimite(DadosAtualizacaoLimite dados){
        cartaoDao.atualizarLimite(dados);
    }

    public List<DadosVisualizarFatura> visualizarFatura(String numeroCartao, LocalDate dataInicial, LocalDate dataFinal) {
        return cartaoDao.visualizarFatura(numeroCartao, dataInicial, dataFinal);
    }


    public Page<DadosEncontrarPeloNumeroCartao> listarCartaoNumero(String numeroCartao, Pageable paginacao) {
        return cartaoDao.listarCartaoNumero(numeroCartao, paginacao);
    }
}

