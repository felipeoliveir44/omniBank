package bank.omnibank.api.controller;

import bank.omnibank.api.dados.cartao.*;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
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
    public Page<DadosListagemCartao> listarCartao(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return service.listarCartao(paginacao);
    }

    @GetMapping("/listar/cpf/{cpf}")
    public Page<DadosEncontrarPeloCpf> listarCartaoCpf(@PathVariable("cpf") String cpf, @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
      return service.listarCartaoCpf(cpf, paginacao);
    }

    @GetMapping("/listar/numero/{numeroCartao}")
    public Page<DadosEncontrarPeloNumeroCartao> listarCartaoNumero(@PathVariable("numeroCartao") String numeroCartao, @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return service.listarCartaoNumero(numeroCartao, paginacao);
    }

    @PutMapping("/atualizarStatus")
    @Transactional
    public ResponseEntity<DadosAtualizacaoCartao> alterarStatus(@RequestBody DadosAtualizacaoCartao dados) {
        service.alterarStatus(dados);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/atualizarLimite")
    @Transactional
    public ResponseEntity<DadosAtualizacaoLimite> atualizarLimite(@RequestBody DadosAtualizacaoLimite dados) {
        service.atualizarLimite(dados);
        return ResponseEntity.ok(dados);

    }


    @PostMapping("/visualizarFatura")
    @Transactional
    public ResponseEntity<List<DadosVisualizarFatura>> visualizarFatura(@RequestBody Map<String, Object> requestBody) {
        String numeroCartao = requestBody.get("numeroCartao").toString();
        LocalDate inicio = LocalDate.parse(requestBody.get("dataInicial").toString());
        LocalDate fim = LocalDate.parse(requestBody.get("dataFinal").toString());
        List<DadosVisualizarFatura> visualizarFatura = service.visualizarFatura(numeroCartao, inicio, fim);
        System.out.println(visualizarFatura);
        if (visualizarFatura != null && !visualizarFatura.isEmpty()) {
            return ResponseEntity.ok(visualizarFatura);
        } else {
            return ResponseEntity.noContent().build(); // Retornar status 204 se a lista estiver vazia
        }

    }
}
