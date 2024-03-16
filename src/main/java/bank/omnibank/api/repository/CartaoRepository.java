package bank.omnibank.api.repository;

import bank.omnibank.api.dados.cartao.DadosAtualizacaoCartao;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    @Procedure(name = "spCadastrarCartao")
    public void spCadastrarCartao(
            @Param("idCliente") Long idCliente,
            @Param("limite")BigDecimal limite
    );

    Page<Cartao> findAllByAtivoTrue(Pageable paginacao);

    @Query(value = "select * from tbcartao where id = 1", nativeQuery = true)
    Cartao cartao();
}
