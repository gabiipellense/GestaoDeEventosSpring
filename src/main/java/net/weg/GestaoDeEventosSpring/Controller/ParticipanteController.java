package net.weg.GestaoDeEventosSpring.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.GestaoDeEventosSpring.Model.Participante;
import net.weg.GestaoDeEventosSpring.Service.ParticipanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/participantes")
@AllArgsConstructor
public class ParticipanteController {
    private ParticipanteService participanteService ;

    @PostMapping
    public ResponseEntity<Participante> cadastroParticipante(@RequestBody Participante participante) {
        participante = participanteService.cadastro(participante) ;
        return new ResponseEntity<>(participante , HttpStatus.CREATED) ;
    }//okay
    @PutMapping("/{id}")
    public ResponseEntity<Participante> edicaoParticipante (@PathVariable Integer id , @RequestBody Participante participante) {
        participante = participanteService.editar(id, participante);
        return new ResponseEntity<>(participante, HttpStatus.OK);
    }//okay
    @PatchMapping
    public ResponseEntity<Participante> alterarEmail (@RequestParam Integer id, @RequestParam String email) {
        try {
            Participante participante = participanteService.editarEmail(id, email) ;
            return new ResponseEntity<>(participante, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }//okay
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerParticipante (@PathVariable Integer id) {
        participanteService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }//okay
    @GetMapping("/{id}")
    public ResponseEntity<Participante> buscarParticipante(@PathVariable Integer id) {
        try {
            Participante participante = participanteService.buscar(id) ;
            return new ResponseEntity<>(participante,HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }//okay
    @GetMapping("/email")
    public ResponseEntity<Participante> buscarParticipante(@RequestParam String email) {
        try {
            Participante participante = participanteService.buscar(email) ;
            return new ResponseEntity<>(participante,HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }//okay
    @GetMapping
    public ResponseEntity<List<Participante>> buscarParticipantes() {
        List<Participante> participantes = participanteService.buscar() ;
        if (!participantes.isEmpty()){
            return new ResponseEntity<>(participantes,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }//okay
}
