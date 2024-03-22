package bank.omnibank.api.model;

import bank.omnibank.api.dados.cartao.DadosAtualizacaoCartao;
import bank.omnibank.api.dados.cartao.DadosAtualizacaoLimite;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tbcartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String validade;
    private String cvv;

    private BigDecimal limite;

    @Column(name = "status")
    private Boolean ativo;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;




    public Long getId() {
        return id;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", validade='" + validade + '\'' +
                ", cvv='" + cvv + '\'' +
                ", limite=" + limite +
                ", statusCartao='" + ativo + '\'' +
                ", cliente=" + cliente +
                '}';
    }

    public void excluir() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void alterarStatus(DadosAtualizacaoCartao dados) {
        if (dados.status() == false) {
            this.ativo = false;
        } else {
            this.ativo = true;
        }
    }

    public void atualizarLimite(DadosAtualizacaoLimite dados) {
        this.limite = dados.limite();
    }
}
