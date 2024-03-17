package bank.omnibank.api.dados.compra;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record DadosPeriodo() {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private static Date inicio;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private static Date fim;

    public static Date getInicio() {
        return inicio;
    }

    public static void setInicio(Date inicio) {
        DadosPeriodo.inicio = inicio;
    }

    public static Date getFim() {
        return fim;
    }

    public static void setFim(Date fim) {
        DadosPeriodo.fim = fim;
    }
}
