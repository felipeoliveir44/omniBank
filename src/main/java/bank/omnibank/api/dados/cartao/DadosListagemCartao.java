package bank.omnibank.api.dados.cartao;

import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Cliente;

import java.math.BigDecimal;

public record DadosListagemCartao(
        Long id,
        String numeroCartao,
        String nomeCliente,
        BigDecimal limiteCartao,
        String dataValidade,
        Boolean status) {
    public DadosListagemCartao(Cartao cartao) {
        this(cartao.getId(), cartao.getNumero(), cartao.getCliente().getNome(), cartao.getLimite(),cartao.getValidade(), cartao.getAtivo());
    }

}
