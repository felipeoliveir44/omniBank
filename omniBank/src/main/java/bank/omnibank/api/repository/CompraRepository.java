package bank.omnibank.api.repository;

import bank.omnibank.api.dados.compra.DadosListagemGastosCategoria;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Cliente;
import bank.omnibank.api.model.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Query("SELECT c.nome AS nomeCategoria, SUM(co.valor) AS totalGasto " +
            "FROM Compra co " +
            "JOIN co.categoriaId c " +
            "WHERE co.cartao.id = :idCartao " +
            "AND YEAR(co.dataCompra) = :ano " +
            "AND MONTH(co.dataCompra) = :mes " +
            "GROUP BY c.nome " +
            "ORDER BY c.nome")
            List<Object[]> somarGastosPorCategoriaNoMes(@Param("idCartao") Long cartaoId,
                                                                            @Param("ano") int ano,
                                                                            @Param("mes") int mes);

}
