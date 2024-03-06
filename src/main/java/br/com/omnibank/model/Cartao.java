package br.com.omnibank.model;

import java.math.BigDecimal;

public class Cartao {
    private int id;
    private String numero;
    private String validade;
    private String cvv;
    private BigDecimal limite;
    private String statusCartao;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatusCartao() {
        return statusCartao;
    }

    public void setStatusCartao(String statusCartao) {
        this.statusCartao = statusCartao;
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
                ", statusCartao='" + statusCartao + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
