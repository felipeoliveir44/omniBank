package bank.omnibank.api.repository;

import bank.omnibank.api.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
    Page<Cliente> findAllByCpfAndAtivoTrue(String cpf, Pageable paginacao);

    @Procedure(name = "spCadastrarCliente")
    public void spCadastrarCliente(
            @Param("nome") String nome,
            @Param("cpf") String cpf,
            @Param("email") String email,
            @Param("telefone") String telefone
    );



}



