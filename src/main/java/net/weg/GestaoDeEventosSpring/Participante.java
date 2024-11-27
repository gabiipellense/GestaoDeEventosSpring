package net.weg.GestaoDeEventosSpring;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "tb_participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nome ;
    private String email ;
    @OneToMany(mappedBy = "participante")
    private List<Inscricao> inscricoes = new ArrayList<>() ;
}
