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

import java.util.List;

@Repository
public class CompraDao {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

//   public void cadastrarCompra (@RequestBody DadosCadastroCompra dadosCadastroCompra) {
//        repository.save(new Compra(dadosCadastroCompra));
//   }

    public void cadastrarCompra(@RequestBody DadosCadastroCompra dados) {
        Cartao cartao = cartaoRepository.getReferenceById(dados.cartaoId());
        Categoria categoria = categoriaRepository.getReferenceById(dados.categoriaId());
        compraRepository.save(new Compra(dados, cartao, categoria));
    }

    public List<Object[]> somarGastosPorCategoriaNoMes(Long cartaoId, int ano, int mes) {
        return compraRepository.somarGastosPorCategoriaNoMes(cartaoId, ano, mes);
    }

//    public void cadastrarCompra(@RequestBody @Valid DadosCadastroCompra dados) {
//        compraRepository.spRealizarCompra(dados.valor(), dados.dataCompra(), dados.categoria(), dados.estabelecimento(), dados.cartaoId());
//    }

}
