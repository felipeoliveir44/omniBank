package bank.omnibank.api.controller;

import bank.omnibank.api.model.Cliente;
import bank.omnibank.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarClientes(@RequestBody @Valid Cliente cliente) {
        clienteService.cadastrarClienteService(cliente.getNome(),cliente.getCpf(), cliente.getEmail(), cliente.getTelefone());
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return null;
    }
}
