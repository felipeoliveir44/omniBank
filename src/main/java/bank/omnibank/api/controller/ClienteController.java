package bank.omnibank.api.controller;

import bank.omnibank.api.dados.cliente.DadosAtualizacaoCliente;
import bank.omnibank.api.dados.cliente.DadosCadastroCliente;
import bank.omnibank.api.dados.cliente.DadosListagemCliente;
import bank.omnibank.api.model.Cliente;
import bank.omnibank.api.repository.ClienteRepository;
import bank.omnibank.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosCadastroCliente> cadastrarClientes(@RequestBody @Valid DadosCadastroCliente cliente) {
        service.cadastrarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/listar")
    public Page<DadosListagemCliente> listarClientes(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {

        return service.listarClientes(paginacao);
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<DadosAtualizacaoCliente> atualizarCliente(@RequestBody DadosAtualizacaoCliente dadosCliente) {

        service.atualizarCliente(dadosCliente);
        return ResponseEntity.ok(dadosCliente);
    }

    @DeleteMapping("/desativar/{id}")
    @Transactional
    public ResponseEntity<Long> excluirCliente(@PathVariable Long id) {
        service.excluirCliente(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<Long> ativarCliente(@PathVariable Long id) {
        service.ativarCliente(id);
        return ResponseEntity.ok(id);
    }
}
