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

    @Query("SELECT c.numero, cl.nome, cl.cpf, SUM(co.valor) AS ValorCompra, co.dataCompra, co.estabelecimento, co.categoria, (SELECT SUM(co.valor) FROM Compra co WHERE co.cartao.id = c.id) AS ValorTotal " +
            "FROM Cartao c " +
            "JOIN c.cliente cl " +
            "JOIN Compra co ON c.id = co.cartao.id " +
            "WHERE c.numero = :numeroCartao " +
            "AND FUNCTION('YEAR', co.dataCompra) = :anoCompra " +
            "AND FUNCTION('MONTH', co.dataCompra) = :mesCompra " +
            "GROUP BY c.numero, cl.nome, cl.cpf, co.dataCompra, co.estabelecimento, co.categoria " +
            "ORDER BY co.dataCompra ASC")

    List<Object[]> visualizarFatura (@Param("numeroCartao") String numeroCartao,
                                     @Param("anoCompra") int anoCompra,
                                     @Param("mesCompra") int mesCompra);


}
