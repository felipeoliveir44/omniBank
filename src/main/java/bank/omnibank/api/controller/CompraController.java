package bank.omnibank.api.controller;

import bank.omnibank.api.dados.compra.DadosCadastroCompra;
import bank.omnibank.api.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private CompraService service;

//    @PostMapping("/cadastrar")
//    @Transactional
//    public ResponseEntity<DadosCadastroCompra> cadastroCompra(@RequestBody DadosCadastroCompra compra) {
//
//       service.cadastroCompra(compra);
//       return ResponseEntity.ok(compra);
//    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosCadastroCompra> cadastrarCompra(@RequestBody DadosCadastroCompra dados) {
        service.cadastroCompra(dados);
        return ResponseEntity.ok(dados);
    }
}
