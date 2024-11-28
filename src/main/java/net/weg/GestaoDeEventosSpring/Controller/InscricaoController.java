package net.weg.GestaoDeEventosSpring.Controller;

import net.weg.GestaoDeEventosSpring.Controller.dto.InscricaoRequestDTO;
import net.weg.GestaoDeEventosSpring.Model.Inscricao;
import net.weg.GestaoDeEventosSpring.Service.InscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    private InscricaoService service;

    @PostMapping
    public ResponseEntity<Inscricao> cadastro (@RequestBody InscricaoRequestDTO dto) {
        try {
            Inscricao inscricao = service.cadastro(dto);
            return new ResponseEntity<>(inscricao, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> edicao (@PathVariable Integer id, @RequestBody InscricaoRequestDTO dto){
        try {
            Inscricao inscricao = service.edicao(id,dto);
            return new ResponseEntity<>(inscricao, HttpStatus.OK);
        }
        catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping
    public ResponseEntity<Inscricao> alterarEvento (@RequestParam Integer idInscricao, @RequestParam Integer idEvento) {
        try {
            Inscricao inscricao = service.trocarEvento(idInscricao,idEvento);
            return new ResponseEntity<>(inscricao,HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscar(@PathVariable Integer id){
        Inscricao inscricao = service.buscarUmaInscricaoPorId(id);
        if (inscricao != null){
            return new ResponseEntity<>(inscricao,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Inscricao>> buscar () {
        List<Inscricao> inscricoes = service.buscarInscricoes();
        if(!inscricoes.isEmpty()){
            return new ResponseEntity<>(inscricoes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/participante/{id}")
    public ResponseEntity<List<Inscricao>> buscarPorParticipante (@PathVariable Integer idParticipante) {
        List<Inscricao> inscricoes = service.buscarPorParticipante(idParticipante);
        if(!inscricoes.isEmpty()){
            return new ResponseEntity<>(inscricoes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/evento/{id}")
    public ResponseEntity<List<Inscricao>> buscarPorEvento(@PathVariable Integer idEvento) {
        List<Inscricao> inscricoes = service.buscarPorEvento(idEvento);
        if(!inscricoes.isEmpty()){
            return new ResponseEntity<>(inscricoes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Integer id){
        try {
            service.removerInscricao(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
