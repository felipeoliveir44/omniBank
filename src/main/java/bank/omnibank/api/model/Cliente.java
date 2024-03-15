package bank.omnibank.api.model;

import bank.omnibank.api.dados.cliente.DadosAtualizacaoCliente;
import bank.omnibank.api.dados.cliente.DadosCadastroCliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbcliente")
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;

    @NotNull
    @Column(name = "status")
    private Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }

        if(dados.cpf() != null) {
            this.cpf = dados.cpf();
        }

        if(dados.email() != null) {
            this.email = dados.email();
        }

        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }


    }
    @Override
    public String toString() {
        return "Dados do cliente: \n" +
                "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Email: " + email + "\n" +
                "Telefone: " + telefone + "\n" +
                "--------------------";


    }

    public void excluir() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
