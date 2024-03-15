package bank.omnibank.api.dados.cartao;

import bank.omnibank.api.dados.cliente.DadosCadastroCliente;

import java.math.BigDecimal;

public record DadosCadastroCartao(
        Long id,
        BigDecimal limite) {

    public DadosCadastroCartao(DadosCadastroCartao dados) {
        this(dados.id(), dados.limite());
    }

}
