package bank.omnibank.api.controller;

import bank.omnibank.api.dados.cartao.DadosAtualizacaoCartao;
import bank.omnibank.api.dados.cartao.DadosCadastroCartao;
import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    public CartaoService service;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosCadastroCartao> cadastrarCartao(@RequestBody DadosCadastroCartao dados) {
        service.cadastrarCartao(dados);
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/listar")
    @Transactional
   public Page<DadosListagemCartao> listarCartao(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return service.listarClientes(paginacao);

   }

   @PutMapping("/atualizarStatus")
   @Transactional
    public ResponseEntity<DadosAtualizacaoCartao> alterarStatus(@RequestBody DadosAtualizacaoCartao dados) {
        service.alterarStatus(dados);
        return ResponseEntity.ok(dados);
   }
}
