package br.com.omnibank.service;

import br.com.omnibank.dao.ClienteDao;
import br.com.omnibank.factory.ConnectionFactory;
import br.com.omnibank.model.Cliente;

import java.util.List;

public class ClienteService {
    private Cliente cliente;
    private ConnectionFactory connectionFactory;

    public ClienteService(String nome, String cpf, String email, String telefone) {
        this.connectionFactory = new ConnectionFactory();
        this.cliente = new Cliente(nome, cpf, email, telefone);
    }

    public void cadastrarClienteService(Cliente cliente) {
        ClienteDao clienteDao = new ClienteDao(connectionFactory.abrirConexaoBD());
        clienteDao.cadastrarCliente(this.cliente);

    }
}
