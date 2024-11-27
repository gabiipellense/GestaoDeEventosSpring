package net.weg.GestaoDeEventosSpring.Controller.dto;

import lombok.Data;
import net.weg.GestaoDeEventosSpring.Model.Evento;
import net.weg.GestaoDeEventosSpring.Model.Participante;
@Data
public class InscricaoRequestDTO {
    private Evento evento;
    private Participante participante;

}
