package bank.omnibank.api.repository;

import bank.omnibank.api.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CompraRepository extends JpaRepository <Compra,Long > {

    @Procedure(name = "spRealizarCompra")
    public void spRealizarCompra(
            @Param("pValor") BigDecimal valor,
            @Param("pDataCompra") LocalDate data,
            @Param("pCategoria") String categoria,
            @Param("pEstabelecimento") String estabelecimento,
            @Param("pIdCartao") Long idCartao
    );
}
