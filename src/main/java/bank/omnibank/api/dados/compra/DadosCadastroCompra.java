package bank.omnibank.api.dados.compra;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroCompra(
        BigDecimal valor,
        LocalDate dataCompra,
        String estabelecimento,
        String categoria,
        Long id_cartao,
        Long id_categoria

) {
    public DadosCadastroCompra(DadosCadastroCompra dadosCadastroCompra) {
        this(dadosCadastroCompra.valor(), dadosCadastroCompra.dataCompra(), dadosCadastroCompra.estabelecimento(), dadosCadastroCompra.categoria(), dadosCadastroCompra.id_cartao(), dadosCadastroCompra.id_categoria());
    }

}
