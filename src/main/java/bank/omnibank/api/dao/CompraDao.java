package bank.omnibank.api.dao;

import bank.omnibank.api.dados.compra.DadosCadastroCompra;
import bank.omnibank.api.repository.CompraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class CompraDao {
    @Autowired
    private CompraRepository compraRepository;

//   public void cadastrarCompra (@RequestBody DadosCadastroCompra dadosCadastroCompra) {
//        repository.save(new Compra(dadosCadastroCompra));
//   }

    public void cadastrarCompra(@RequestBody @Valid DadosCadastroCompra dados) {
        compraRepository.spRealizarCompra(dados.valor(), dados.dataCompra(), dados.categoria(), dados.estabelecimento(), dados.cartaoId());
    }

}
