package bank.omnibank.api.dados.cliente;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone) {
}
