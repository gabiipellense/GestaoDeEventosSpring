package net.weg.GestaoDeEventosSpring;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @ManyToOne
    private Evento evento;

    //Na anotação: primeira infotmação relacionada a propria classe e dps do To é da classe relacionada
    @ManyToOne
    private Participante participante ;
}
