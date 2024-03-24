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

    @Query("SELECT c.nome AS nome_cliente, MAX(co.valor) AS maior_valor_compra " +
            "FROM Cartao ca " +
            "JOIN ca.cliente c " +
            "JOIN Compra co " +
            "ON c.id = ca.cliente.id AND ca.id = co.cartao.id " +
            "WHERE co.dataCompra BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY c.id, c.nome " +
            "ORDER BY maior_valor_compra DESC")
    List<Object[]> comprasMaiorValor(@Param("dataInicial") LocalDate inicio,
                                     @Param("dataFinal") LocalDate fim);

    @Query("SELECT c.nome FROM Cartao ca " +
            "LEFT JOIN Cliente c ON ca.cliente.id = c.id " +
            "LEFT JOIN Compra co ON ca.id = co.cartao.id " +
            "WHERE co.id IS NULL " +
            "ORDER BY c.nome ASC")
    List<Object[]> clientesSemCompras(@Param("inicio") LocalDate inicio,
                                     @Param("fim") LocalDate fim);

    @Query("SELECT c.nome AS nome_cliente, COUNT(co.id) AS quantidade_compras " +
            "FROM Cartao ca " +
            "LEFT JOIN ca.cliente c " +
            "LEFT JOIN Compra co ON ca.id = co.cartao.id " + // Adicionando a condição de junção
            "WHERE co.dataCompra BETWEEN :inicio AND :fim " +
            "GROUP BY c.id, c.nome " +
            "ORDER BY quantidade_compras DESC")
    List<Object[]> buscarQuantidadeCompras(
            @Param("inicio") LocalDate inicio,
            @Param("fim") LocalDate fim);
}
