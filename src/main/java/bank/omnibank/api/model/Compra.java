package bank.omnibank.api.model;

import bank.omnibank.api.dados.cliente.DadosCadastroCliente;
import bank.omnibank.api.dados.compra.DadosCadastroCompra;
import bank.omnibank.api.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "tbcompra")
@Getter
@Setter
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @Column(name = "estabelecimento")
    private String estabelecimento;


    @Column(name = "categoria")
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "id_cartao")
    private Cartao cartao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoriaId;


    public Compra(DadosCadastroCompra dados) {
        this.valor = dados.valor();
        this.dataCompra = LocalDate.now();
        this.estabelecimento = dados.estabelecimento();
        this.categoria = dados.categoria();
        this.cartao = getCartao();
    }

    public Compra() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }
}