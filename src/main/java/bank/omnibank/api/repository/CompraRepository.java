package bank.omnibank.api.repository;

import bank.omnibank.api.dados.compra.DadosListagemGastosCategoria;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Cliente;
import bank.omnibank.api.model.Compra;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CompraRepository extends JpaRepository <Compra,Long > {

    @Procedure(name = "spRealizarCompra")
    public void spRealizarCompra(
            @Param("pValor") BigDecimal valor,
            @Param("pDataCompra") LocalDate data,
            @Param("pCategoria") String categoria,
            @Param("pEstabelecimento") String estabelecimento,
            @Param("pIdCartao") Long idCartao
    );



    List<Compra> findByIdIsNotNullAndDataCompraBetween(LocalDate inicio, LocalDate fim, Sort sort);

    List<Compra> findByIdIsNull(Sort sort);


}
