package bank.omnibank.api.controller;

import bank.omnibank.api.dados.cartao.DadosCadastroCartao;
import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarCartao(@RequestBody DadosCadastroCartao dados) {
        cartaoService.cadastrarCartao(dados.id(),dados.limite());
    }

    @GetMapping("/listar")
    @Transactional
   public List<DadosListagemCartao> listarCartao() {
        return cartaoService.listarClientesService();
   }
}
