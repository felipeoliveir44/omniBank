package bank.omnibank.api.repository;

import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    @Procedure(name = "spCadastrarCartao")
    public void spCadastrarCartao(
            @Param("idCliente") Long idCliente,
            @Param("limite")BigDecimal limite
    );

    Page<Cartao> findAll(Pageable paginacao);

    @Query("SELECT ca.numero, c.nome, ca.limite, ca.validade FROM Cartao ca JOIN Cliente c ON ca.cliente.id = c.id WHERE c.cpf = :cpf")
    Page<Cartao> encontrarPeloCpf(@Param("cpf") String cpf, Pageable paginacao);
    @Query("SELECT ca.numero, c.nome, ca.limite, ca.validade FROM Cartao ca JOIN Cliente c ON ca.cliente.id = c.id WHERE ca.numero = :numeroCartao")
    Page<Cartao> encontrarPeloNumeroCartao(@Param("numeroCartao") String numeroCartao, Pageable paginacao);

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
