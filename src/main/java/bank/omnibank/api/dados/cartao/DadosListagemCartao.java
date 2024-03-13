package bank.omnibank.api.dados.cartao;

import java.math.BigDecimal;

public record DadosListagemCartao(
        String numeroCartao,
        String nomeCliente,
        BigDecimal limiteCartao,
        String dataValidade) {
}
