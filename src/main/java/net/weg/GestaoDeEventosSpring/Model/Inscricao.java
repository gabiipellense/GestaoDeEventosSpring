package net.weg.GestaoDeEventosSpring.Model;

import jakarta.persistence.*;
import lombok.Data;
import net.weg.GestaoDeEventosSpring.Model.Evento;
import net.weg.GestaoDeEventosSpring.Model.Participante;

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
