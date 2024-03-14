package bank.omnibank.api.dao;

import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.dados.cliente.DadosAtualizacaoCliente;
import bank.omnibank.api.dados.cliente.DadosCadastroCliente;
import bank.omnibank.api.dados.cliente.DadosListagemCliente;
import bank.omnibank.api.model.Cliente;
import bank.omnibank.api.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class ClienteDao {
    @Autowired
    private ClienteRepository repository;

    public void cadastrarClientes(@RequestBody @Valid DadosCadastroCliente cliente) {
        repository.spCadastrarCliente(cliente.nome(), cliente.cpf(), cliente.email(), cliente.telefone());
        // repository.cadastrarClienteProcedure(cliente.nome(), cliente.cpf(), cliente.email(), cliente.telefone());
        // repository.save(new Cliente(cliente));
    }


    public Page<DadosListagemCliente> listarClientes(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    public void atualizarCliente(@RequestBody DadosAtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }


    public void deletarCliente(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
    }

    public void ativarCliente(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.ativar();
    }


}
