package bank.omnibank.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbcategoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
}
