package net.weg.GestaoDeEventosSpring.Controller.dto;

import lombok.Data;
import net.weg.GestaoDeEventosSpring.Model.Evento;
import net.weg.GestaoDeEventosSpring.Model.Inscricao;
import net.weg.GestaoDeEventosSpring.Model.Participante;
@Data
public class InscricaoRequestDTO {
    private Evento evento;
    private Participante participante;

    public Inscricao conversao () {
        Inscricao inscricao = new Inscricao();
        inscricao.setEvento(this.getEvento());
        inscricao.setParticipante(this.getParticipante());
        return inscricao ;
    }
}
