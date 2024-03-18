package bank.omnibank.api.service;

import bank.omnibank.api.model.Compra;
import bank.omnibank.api.repository.CompraRepository;
import bank.omnibank.api.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class RelatorioClienteService {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private RelatorioRepository relatorioRepository;

    public List<Compra> clientesComMaisCompras(LocalDate inicio, LocalDate fim) {
        return compraRepository.findByIdIsNotNullAndDataCompraBetween(inicio, fim, Sort.by("nome"));
    }

    public List<Compra> clientesSemCompras() {
        return compraRepository.findByIdIsNull(Sort.by("nome"));
    }


    public List<Object[]> comprasMaiorValor(LocalDate inicio, LocalDate fim) {
        return relatorioRepository.comprasMaiorValor(inicio, fim);
    }

    public List<Object[]> somarGastosPorCategoriaNoMes(Long cartaoId, int ano, int mes) {
        return relatorioRepository.somarGastosPorCategoriaNoMes(cartaoId, ano, mes);
    }


}

