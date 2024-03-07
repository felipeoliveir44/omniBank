package br.com.omnibank;

import br.com.omnibank.model.Cartao;
import br.com.omnibank.model.Cliente;
import br.com.omnibank.service.CartaoService;
import br.com.omnibank.service.ClienteService;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;


public class Main {
    static ClienteService clienteService = new ClienteService();
    static CartaoService cartaoService = new CartaoService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("""
                Qual função gostaria de realizar:
                1 - Criar cliente
                2 - Cadastrar cartão
                3 - Listar cartões
                """);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    cadastrarCartao();
                    break;
                case 3:
                    listagemDeCartao();
                    break;
            }

    }
    private static void criarCliente() {
        System.out.println("Digite nome do cliente:");
        String clienteNome = scanner.next();
        System.out.println("Digite o cpf do cliente:");
        String clienteCpf = scanner.next();
        System.out.println("Digite o email do cliente:");
        String clienteEmail = scanner.next();
        System.out.println("Digite o telefone do cliente:");
        String clienteTelefone = scanner.next();
        clienteService.cadastrarClienteService(clienteNome, clienteCpf, clienteEmail, clienteTelefone);
        System.out.println("Conta aberta com sucesso!");
    }

    private static void cadastrarCartao() {
        scanner.useLocale(Locale.US);
        System.out.println("Digite o ID do cliente:");
        int clienteId = scanner.nextInt();
        System.out.println("Digite o limite desejado");
        BigDecimal clienteLimite = scanner.nextBigDecimal();
        cartaoService.cadastrarCartao(clienteId, clienteLimite);
    }

    private static void listagemDeCartao() {
        System.out.println("Listagem de cartões: ");
        CartaoService cartaoService = new CartaoService();
        var cartaoList = cartaoService.listarCartoesPorCliente("");
        cartaoList.stream().forEach(System.out::println);
    }

}