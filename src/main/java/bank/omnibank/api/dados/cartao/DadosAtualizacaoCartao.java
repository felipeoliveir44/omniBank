package bank.omnibank.api.dados.cartao;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCartao(
        @NotNull
        Long id,
        Boolean status) {


}
