package bank.omnibank.api.dados.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String cpf() {
        return cpf;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String telefone() {
        return telefone;
    }
}
