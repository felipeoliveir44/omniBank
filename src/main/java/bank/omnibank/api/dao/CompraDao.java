package bank.omnibank.api.dao;

import bank.omnibank.api.dados.compra.DadosCadastroCompra;
import bank.omnibank.api.model.Cartao;
import bank.omnibank.api.model.Categoria;
import bank.omnibank.api.model.Compra;
import bank.omnibank.api.repository.CartaoRepository;
import bank.omnibank.api.repository.CategoriaRepository;
import bank.omnibank.api.repository.CompraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CompraDao {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    public void cadastrarCompra(@RequestBody DadosCadastroCompra dados) {
        Cartao cartao = cartaoRepository.getReferenceById(dados.cartaoId());
        Categoria categoria = categoriaRepository.getReferenceById(dados.categoriaId());
        compraRepository.save(new Compra(dados, cartao, categoria));
    }

}
