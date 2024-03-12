package bank.omnibank.api.dados.cartao;

import java.math.BigDecimal;

public record DadosCadastroCartao(
        Long id,
        BigDecimal limite) {

}
