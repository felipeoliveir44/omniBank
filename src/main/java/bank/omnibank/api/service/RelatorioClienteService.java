package bank.omnibank.api.service;

import bank.omnibank.api.model.Compra;
import bank.omnibank.api.repository.CompraRepository;
import bank.omnibank.api.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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

    public List<Object[]> clientesComMaisCompras(LocalDate inicio, LocalDate fim) {
        return relatorioRepository.buscarQuantidadeCompras(inicio, fim);
    }

    public List<Object[]> clientesSemCompras(LocalDate inicio, LocalDate fim) {
        return relatorioRepository.clientesSemCompras(inicio, fim);

    }

    public List<Object[]> comprasMaiorValor(LocalDate inicio, LocalDate fim) {
        return relatorioRepository.comprasMaiorValor(inicio, fim);
    }

    public List<Object[]> somarGastosPorCategoriaNoMes(Long cartaoId, LocalDate dataInicial, LocalDate dataFinal) {
        return relatorioRepository.somarGastosPorCategoriaNoMes(cartaoId, dataInicial, dataFinal);
    }
}

