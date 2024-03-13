package bank.omnibank.api.controller;

import bank.omnibank.api.dados.cartao.DadosCadastroCartao;
import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    /*@Autowired


    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarCartao(@RequestBody DadosCadastroCartao dados) {

    }

    @GetMapping("/listar")
    @Transactional
   public List<DadosListagemCartao> listarCartao() {
        return null;

   }*/
}
