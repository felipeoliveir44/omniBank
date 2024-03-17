package bank.omnibank.api.service;

import bank.omnibank.api.model.Compra;
import bank.omnibank.api.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RelatorioClienteService {
    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> clientesComMaisCompras(Date inicio, Date fim) {
        return compraRepository.findByIdIsNotNullAndDataCompraBetween(inicio, fim, Sort.by("nome"));
    }

    public List<Compra> clientesComMaiorCompra(Date inicio, Date fim) {
        return compraRepository.findByIdIsNotNullAndDataCompraBetween(inicio, fim,  Sort.by(Sort.Direction.DESC, "valor"));
    }

    public List<Compra> clientesSemCompras() {
        return compraRepository.findByIdIsNull(Sort.by("nome"));
    }

    public List<Compra> buscarComprasPorPeriodo(Date inicio, Date fim) {
        Sort sort = Sort.by(Sort.Direction.DESC, "valor");
        return compraRepository.findByIdIsNotNullAndDataCompraBetween(inicio, fim, sort);
    }
}

