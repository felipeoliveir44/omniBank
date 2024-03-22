package bank.omnibank.api.controller;

import bank.omnibank.api.dados.cartao.DadosAtualizacaoCartao;
import bank.omnibank.api.dados.cartao.DadosAtualizacaoLimite;
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
    @Transactional
    public Page<DadosListagemCartao> listarCartao(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return service.listarCartao(paginacao);

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
    public ResponseEntity<List<Object[]>> visualizarFatura(@RequestBody Map<String, Object> requestBody) {
        String numeroCartao = requestBody.get("numeroCartao").toString();
        int anoCompra = Integer.parseInt(requestBody.get("anoCompra").toString());
        int mesCompra = Integer.parseInt(requestBody.get("mesCompra").toString());
        List<Object[]> visualizarFatura = service.visualizarFatura(numeroCartao, anoCompra, mesCompra);
        if (visualizarFatura != null && !visualizarFatura.isEmpty()) {
            return ResponseEntity.ok(visualizarFatura);
        } else {
            return ResponseEntity.noContent().build(); // Retornar status 204 se a lista estiver vazia
        }

    }
}
