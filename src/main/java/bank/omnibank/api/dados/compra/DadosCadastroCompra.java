package bank.omnibank.api.dados.compra;

import bank.omnibank.api.dados.cliente.DadosCadastroCliente;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Categoria;
import bank.omnibank.api.model.Compra;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosCadastroCompra(
        BigDecimal valor,
        LocalDate dataCompra,
        String estabelecimento,
        String categoria,
        Long cartaoId

) {
    public DadosCadastroCompra(DadosCadastroCompra dados) {
        this(dados.valor(), dados.dataCompra(), dados.estabelecimento(), dados.categoria(), dados.cartaoId());
    }
}
