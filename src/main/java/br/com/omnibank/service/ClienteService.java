package br.com.omnibank.service;

import br.com.omnibank.dao.ClienteDao;
import br.com.omnibank.factory.ConnectionFactory;
import br.com.omnibank.model.Cliente;

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
