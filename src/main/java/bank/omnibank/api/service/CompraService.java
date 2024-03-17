package bank.omnibank.api.service;

import bank.omnibank.api.dados.compra.DadosCadastroCompra;
import bank.omnibank.api.dao.CompraDao;
import bank.omnibank.api.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    private CompraDao compraDao;
    public void cadastroCompra(DadosCadastroCompra dadosCadastroCompra) {
        compraDao.cadastrarCompra(dadosCadastroCompra);
    }

    public List<Object[]> somarGastosPorCategoriaNoMes(Long cartaoId, int ano, int mes) {
        return compraDao.somarGastosPorCategoriaNoMes(cartaoId, ano, mes);
    }

}
