package net.weg.GestaoDeEventosSpring.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nome ;
    private String local;
    private String data ;
    private String descricao ;
    @OneToMany(mappedBy = "evento")
    private List<Inscricao>inscricoes = new ArrayList<>();

}
