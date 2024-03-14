package bank.omnibank.api.service;

import bank.omnibank.api.dados.cliente.DadosAtualizacaoCliente;
import bank.omnibank.api.dados.cliente.DadosCadastroCliente;
import bank.omnibank.api.dados.cliente.DadosListagemCliente;
import bank.omnibank.api.dao.ClienteDao;
import bank.omnibank.api.model.Cliente;
import bank.omnibank.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ClienteService {
    @Autowired
    private ClienteDao clienteDao;

    public void cadastrarCliente(DadosCadastroCliente cliente) {

        if(cliente == null) return;
        clienteDao.cadastrarClientes(cliente);
    }

    public Page<DadosListagemCliente> listarClientes(Pageable paginacao) {
        return clienteDao.listarClientes(paginacao);
    }

    public void atualizarCliente(DadosAtualizacaoCliente dados) {
        clienteDao.atualizarCliente(dados);
    }

    public void excluirCliente(@PathVariable Long id) {
        clienteDao.deletarCliente(id);
    }

    public void ativarCliente(@PathVariable Long id) {
        clienteDao.ativarCliente(id);
    }


}
