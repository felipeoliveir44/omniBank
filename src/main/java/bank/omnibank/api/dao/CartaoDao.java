package bank.omnibank.api.dao;

import bank.omnibank.api.dados.cartao.DadosAtualizacaoCartao;
import bank.omnibank.api.dados.cartao.DadosAtualizacaoLimite;
import bank.omnibank.api.dados.cartao.DadosCadastroCartao;
import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.dados.cliente.DadosAtualizacaoCliente;
import bank.omnibank.api.dados.cliente.DadosListagemCliente;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.repository.CartaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CartaoDao {

    @Autowired
    private CartaoRepository repository;

    public void cadastrarCartao(@RequestBody @Valid DadosCadastroCartao dados) {
        repository.spCadastrarCartao(dados.id(), dados.limite());
    }

    public Page<DadosListagemCartao> listarCartao(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCartao::new);
    }

    public void atualizarStatus(@RequestBody DadosAtualizacaoCartao dados) {
        var cartao = repository.getReferenceById(dados.id());
        cartao.alterarStatus(dados);
    }

    public void atualizarLimite(@RequestBody DadosAtualizacaoLimite dados) {
        var cartao = repository.getReferenceById(dados.id());
        cartao.atualizarLimite(dados);
    }

    public List<Object[]> visualizarFatura(String numeroCartao, int anoCompra, int mesCompra) {
        return repository.visualizarFatura(numeroCartao, anoCompra, mesCompra);
    }

    public Page<Cartao> listarCartaoCpf(@PathVariable String cpf, @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.encontrarPeloCpf(cpf, paginacao);
    }

    public Page<Cartao> listarCartaoNumero(@PathVariable String numeroCartao, Pageable paginacao) {
        return repository.encontrarPeloNumeroCartao(numeroCartao, paginacao);
    }
}
