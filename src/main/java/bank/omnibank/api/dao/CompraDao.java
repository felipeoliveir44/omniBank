package bank.omnibank.api.dao;

import bank.omnibank.api.dados.compra.DadosCadastroCompra;
import bank.omnibank.api.model.Compra;
import bank.omnibank.api.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class CompraDao {
    @Autowired
    private CompraRepository repository;
    public void cadastrarCompra (@RequestBody DadosCadastroCompra dadosCadastroCompra) {

//        repository.save(new Compra(dadosCadastroCompra));


    }

}
