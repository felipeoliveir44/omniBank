package bank.omnibank.api.repository;

import bank.omnibank.api.dados.relatorio.DadosListagemBuscarQuantidadeCompras;
import bank.omnibank.api.dados.relatorio.DadosListagemClientesSemCompras;
import bank.omnibank.api.dados.relatorio.DadosListagemComprasMaiorValor;
import bank.omnibank.api.dados.relatorio.DadosListagemGastoCategoria;
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
            "JOIN Categoria c ON co.categoriaId.id = c.id " +
            "WHERE co.cartao.id = :idCartao " +
            "AND co.dataCompra BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY c.nome " +
            "ORDER BY c.nome")
    List<DadosListagemGastoCategoria> somarGastosPorCategoriaNoMes(@Param("idCartao") Long cartaoId,
                                                                   @Param("dataInicial") LocalDate dataInicial,
                                                                   @Param("dataFinal") LocalDate dataFinal);

    @Query("SELECT c.nome AS nomeCliente, MAX(co.valor) AS maiorValorCompra " +
            "FROM Cartao ca " +
            "JOIN ca.cliente c " +
            "JOIN Compra co " +
            "ON c.id = ca.cliente.id AND ca.id = co.cartao.id " +
            "WHERE co.dataCompra BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY c.id, c.nome " +
            "ORDER BY maiorValorCompra DESC")
    List<DadosListagemComprasMaiorValor> comprasMaiorValor(@Param("dataInicial") LocalDate inicio,
                                                           @Param("dataFinal") LocalDate fim);

    @Query("SELECT c.nome as nome FROM Cartao ca " +
            "LEFT JOIN Cliente c ON ca.cliente.id = c.id " +
            "LEFT JOIN Compra co ON ca.id = co.cartao.id " +
            "WHERE co.id IS NULL " +
            "ORDER BY c.nome ASC")
    List<DadosListagemClientesSemCompras> clientesSemCompras(@Param("inicio") LocalDate inicio,
                                                             @Param("fim") LocalDate fim);

    @Query("SELECT c.nome AS nomeCliente, COUNT(co.id) AS quantidadeCompras " +
            "FROM Cartao ca " +
            "LEFT JOIN ca.cliente c " +
            "LEFT JOIN Compra co ON ca.id = co.cartao.id " + // Adicionando a condição de junção
            "WHERE co.dataCompra BETWEEN :inicio AND :fim " +
            "GROUP BY c.id, c.nome " +
            "ORDER BY quantidadeCompras DESC")
    List<DadosListagemBuscarQuantidadeCompras> buscarQuantidadeCompras(
            @Param("inicio") LocalDate inicio,
            @Param("fim") LocalDate fim);
}
