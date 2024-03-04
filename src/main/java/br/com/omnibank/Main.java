package br.com.omnibank;

import br.com.omnibank.model.Cliente;
import br.com.omnibank.service.ClienteService;

public class Main {
    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService("Teste", "99999999999", "teste@gmail.com", "99999999999");

        clienteService.cadastrarClienteService(new Cliente("Teste", "99999999999", "teste@gmail.com", "99999999999"));
    }
}