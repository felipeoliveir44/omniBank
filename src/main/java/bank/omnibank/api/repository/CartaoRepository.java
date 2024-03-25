package bank.omnibank.api.repository;

import bank.omnibank.api.dados.cartao.DadosEncontrarPeloCpf;
import bank.omnibank.api.dados.cartao.DadosEncontrarPeloNumeroCartao;
import bank.omnibank.api.dados.cartao.DadosListagemCartao;
import bank.omnibank.api.dados.cartao.DadosVisualizarFatura;
import bank.omnibank.api.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    @Procedure(name = "spCadastrarCartao")
    public void spCadastrarCartao(
            @Param("idCliente") Long idCliente,
            @Param("limite")BigDecimal limite
    );

    Page<Cartao> findAll(Pageable paginacao);

    @Query("SELECT ca.numero as numero, c.nome as nome, ca.limite as limite, ca.validade as validade FROM Cartao ca JOIN Cliente c ON ca.cliente.id = c.id WHERE c.cpf = :cpf")
    Page<DadosEncontrarPeloCpf> encontrarPeloCpf(@Param("cpf") String cpf, Pageable paginacao);
    @Query("SELECT ca.numero as numero, c.nome as nome, ca.limite as limite, ca.validade as validade FROM Cartao ca JOIN Cliente c ON ca.cliente.id = c.id WHERE ca.numero = :numeroCartao")
    Page<DadosEncontrarPeloNumeroCartao> encontrarPeloNumeroCartao(@Param("numeroCartao") String numeroCartao, Pageable paginacao);

    @Query("SELECT c.numero as numero, cl.nome as nome, cl.cpf as cpf, SUM(co.valor) AS valorCompra, co.dataCompra as dataCompra, co.estabelecimento as estabelecimento, co.categoria as categoria, (SELECT SUM(co.valor) FROM Compra co WHERE co.cartao.id = c.id) AS valorTotal " +
            "FROM Cartao c " +
            "JOIN c.cliente cl " +
            "JOIN Compra co ON c.id = co.cartao.id " +
            "WHERE c.numero = :numeroCartao " +
            "AND co.dataCompra BETWEEN :dataInicio AND :dataFinal " +
            "GROUP BY c.numero, cl.nome, cl.cpf, co.dataCompra, co.estabelecimento, co.categoria " +
            "ORDER BY co.dataCompra ASC")
    List<DadosVisualizarFatura> visualizarFatura (@Param("numeroCartao") String numeroCartao,
                                                  @Param("dataInicio") LocalDate dataInicio,
                                                  @Param("dataFinal") LocalDate dataFinal);




}
