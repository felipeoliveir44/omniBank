package bank.omnibank.api.repository;

import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Cliente;
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
import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    @Procedure(name = "spCadastrarCartao")
    public void spCadastrarCartao(
            @Param("idCliente") Long idCliente,
            @Param("limite")BigDecimal limite
    );

    Page<Cartao> findAllByAtivoTrue(Pageable paginacao);

    @Query("SELECT c.numero AS Cartao, cl.nome AS Cliente, cl.cpf AS CPF, " +
            "(SELECT SUM(co2.valor) FROM Compra co2 WHERE co2.cartao.id = c.id) AS ValorTotal, " +
            "co.dataCompra AS Data, co.estabelecimento AS Estabelecimento, " +
            "co.categoria AS Categoria, co.valor AS ValorCompra " +
            "FROM Cartao c " +
            "JOIN c.cliente cl " +
            "JOIN Compra co ON c.id = co.cartao.id " +
            "WHERE c.numero = :numeroCartao AND co.dataCompra = :dataCompra " +
            "ORDER BY co.dataCompra")

    List<Object[]> visualizarFatura (@Param("numeroCartao") String numeroCartao,
                                                @Param("dataCompra") LocalDate dataCompra);

}
