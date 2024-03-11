package bank.omnibank.api.service;

import bank.omnibank.api.dao.ClienteDao;
import bank.omnibank.api.factory.ConnectionFactory;
import bank.omnibank.api.model.Cliente;

import java.util.List;

public class ClienteService {
    private Cliente cliente;
    private ConnectionFactory connectionFactory;

    public ClienteService() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastrarClienteService(String nome, String cpf, String email, String telefone) {
        ClienteDao clienteDao = new ClienteDao(connectionFactory.abrirConexaoBD());
        clienteDao.cadastrarCliente(new Cliente(nome, cpf, email, telefone));

    }

}
