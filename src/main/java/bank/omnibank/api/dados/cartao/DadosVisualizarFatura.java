package bank.omnibank.api.dados.cartao;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface DadosVisualizarFatura {
    String getNome();
    String getNumero();
    String getCpf();
    BigDecimal getValorCompra();
    LocalDate getDataCompra();
    String getEstabelecimento();
    String getCategoria();
    BigDecimal getValorTotal();
}
