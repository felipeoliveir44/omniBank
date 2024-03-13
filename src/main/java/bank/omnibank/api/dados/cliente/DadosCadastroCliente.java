package bank.omnibank.api.dados.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone) {
    public DadosCadastroCliente(DadosCadastroCliente cliente) {
        this(cliente.nome, cliente.cpf, cliente.email, cliente.telefone);
    }
}
