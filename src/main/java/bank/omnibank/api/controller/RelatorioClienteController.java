package bank.omnibank.api.controller;

import bank.omnibank.api.model.Compra;
import bank.omnibank.api.service.RelatorioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/relatorio")
public class RelatorioClienteController {
    @Autowired
    private RelatorioClienteService relatorioClienteService;

    @PostMapping("/gastosCategoria")
    @Transactional
    public ResponseEntity<List<Object[]>> listarCompras(@RequestBody Map<String, Object> requestBody) {
        Long idCartao = Long.parseLong(requestBody.get("idCartao").toString());
        int ano = Integer.parseInt(requestBody.get("ano").toString());
        int mes = Integer.parseInt(requestBody.get("mes").toString());

        List<Object[]> listaGastos = relatorioClienteService.somarGastosPorCategoriaNoMes(idCartao, ano, mes);
        if (listaGastos != null && !listaGastos.isEmpty()) {
            return ResponseEntity.ok(listaGastos);
        } else {
            return ResponseEntity.noContent().build(); // Retornar status 204 se a lista estiver vazia
        }
    }

    @GetMapping("/mais-compras")
    public ResponseEntity<List<Compra>> clientesComMaisCompras(@RequestBody LocalDate inicio, LocalDate fim) {
        List<Compra> clientes = relatorioClienteService.clientesComMaisCompras(inicio, fim);
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/maiorValor")
    @Transactional
    public ResponseEntity<List<Object[]>> comprasMaiorValor(@RequestBody Map<String, Object> requestBody) {
        LocalDate inicio = LocalDate.parse(requestBody.get("inicio").toString());
        LocalDate fim = LocalDate.parse(requestBody.get("fim").toString());
        List<Object[]> comprasMaiorValor = relatorioClienteService.comprasMaiorValor(inicio, fim);
        if (comprasMaiorValor != null && !comprasMaiorValor.isEmpty()) {
            return ResponseEntity.ok(comprasMaiorValor);
        } else {
            return ResponseEntity.noContent().build(); // Retornar status 204 se a lista estiver vazia
        }
    }

    @PostMapping("/semCompras")
    @Transactional
    public ResponseEntity<List<Object[]>> clientesSemCompras(@RequestBody Map<String, Object> requestBody) {
        LocalDate inicio = LocalDate.parse(requestBody.get("inicio").toString());
        LocalDate fim = LocalDate.parse(requestBody.get("fim").toString());
        List<Object[]> clientesSemCompras = relatorioClienteService.clientesSemCompras(inicio, fim);
        if (clientesSemCompras != null && !clientesSemCompras.isEmpty()) {
            return ResponseEntity.ok(clientesSemCompras);
        } else {
            return ResponseEntity.noContent().build(); // Retornar status 204 se a lista estiver vazia
        }
    }
}


