package bank.omnibank.api.controller;

import bank.omnibank.api.dados.cliente.DadosListagemCliente;
import bank.omnibank.api.model.Categoria;
import bank.omnibank.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;
    @GetMapping("/listar")
    public List<Categoria> listarCategoria() {
        return repository.findAll();
    }
}
