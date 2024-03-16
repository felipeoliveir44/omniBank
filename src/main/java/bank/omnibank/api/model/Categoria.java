package bank.omnibank.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbcategoria")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
