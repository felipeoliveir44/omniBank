package bank.omnibank.api.repository;

import bank.omnibank.api.model.Compra;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RelatorioRepository extends JpaRepository<Compra, Long> {

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

    @Query("SELECT c.id, c.cartao.cliente.nome, c.categoriaId.nome , c.dataCompra, c.estabelecimento, c.valor " +
            "FROM Compra c " +
            "WHERE c.id IS NOT NULL " +
            "AND c.dataCompra BETWEEN :dataInicial AND :dataFinal " +
            "ORDER BY c.cartao.cliente.nome ASC")
    List<Object[]> comprasMaiorValor(@Param("dataInicial") LocalDate inicio,
                                     @Param("dataFinal") LocalDate fim);

    @Query("SELECT c.nome FROM Cartao ca " +
            "LEFT JOIN Cliente c ON ca.cliente.id = c.id " +
            "LEFT JOIN Compra co ON ca.id = co.cartao.id " +
            "WHERE co.id IS NULL " +
            "ORDER BY c.nome ASC")
    List<Object[]> clientesSemCompras(@Param("inicio") LocalDate inicio,
                                     @Param("fim") LocalDate fim);


}
