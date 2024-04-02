package bank.omnibank.api.dados.cliente;

import bank.omnibank.api.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemCliente(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        Boolean status) {


    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(),cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getAtivo());
    }
}
