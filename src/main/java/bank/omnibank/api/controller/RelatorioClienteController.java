package bank.omnibank.api.controller;

import bank.omnibank.api.dados.compra.DadosPeriodo;
import bank.omnibank.api.model.Cliente;
import bank.omnibank.api.model.Compra;
import bank.omnibank.api.service.RelatorioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/relatorio-clientes")
public class RelatorioClienteController {
    @Autowired
    private RelatorioClienteService relatorioClienteService;

    @GetMapping("/mais-compras")
    public ResponseEntity<List<Compra>> clientesComMaisCompras(@RequestBody Date inicio, Date fim) {
        List<Compra> clientes = relatorioClienteService.clientesComMaisCompras(inicio, fim);
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/maior-compra")
    public ResponseEntity<List<Compra>> clientesComMaiorCompra(@RequestBody DadosPeriodo periodo) {
        Date inicio = periodo.getInicio();
        Date fim = periodo.getFim();
        List<Compra> compra = relatorioClienteService.clientesComMaiorCompra(inicio, fim);
        return ResponseEntity.ok(compra);
    }
    @GetMapping("/compras")
    public List<Compra> buscarComprasPorPeriodo(@RequestParam Date inicio, @RequestParam Date fim) {
        return relatorioClienteService.buscarComprasPorPeriodo(inicio, fim);
    }

}

//    @GetMapping("/sem-compras")
//    public ResponseEntity<List<Compra>> clientesSemCompras() {
//        List<Compra> clientes = relatorioClienteService.clientesSemCompras();
//        return ResponseEntity.ok(clientes);
