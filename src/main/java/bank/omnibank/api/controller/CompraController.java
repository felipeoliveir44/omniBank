package bank.omnibank.api.controller;

import bank.omnibank.api.dados.compra.DadosCadastroCompra;
import bank.omnibank.api.dados.compra.DadosListagemGastosCategoria;
import bank.omnibank.api.repository.CompraRepository;
import bank.omnibank.api.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private CompraService service;

   @PostMapping("/cadastrar")
   @Transactional
   public ResponseEntity<DadosCadastroCompra> cadastroCompra(@RequestBody DadosCadastroCompra compra) {
       service.cadastroCompra(compra);
       return ResponseEntity.ok(compra);
   }

}
