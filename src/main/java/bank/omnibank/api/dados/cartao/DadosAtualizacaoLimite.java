package bank.omnibank.api.dados.cartao;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoLimite(
        @NotNull
        Long id,
        BigDecimal limite
) {
}
