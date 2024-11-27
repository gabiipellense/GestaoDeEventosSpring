package net.weg.GestaoDeEventosSpring.Controller;

import lombok.AllArgsConstructor;
import net.weg.GestaoDeEventosSpring.Model.Evento;
import net.weg.GestaoDeEventosSpring.Repository.EventoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@AllArgsConstructor
public class EventoController {
    private EventoRepository eventoRepository;
    @PostMapping
    public void create (@RequestBody Evento evento) {
        eventoRepository.save(evento) ;
    }
    @PutMapping
    public void update (@RequestBody Evento evento) {
        eventoRepository.save(evento) ;
    }
    @PatchMapping
    public void trocarData (@RequestParam Integer id, @RequestParam String data) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id) ;
        Evento evento = eventoOptional.get();
        evento.setData(data);
        eventoRepository.save(evento);
    }
    @DeleteMapping("{id}")
    public void delete (@PathVariable Integer id) {
        eventoRepository.deleteById(id);
        //EXEMPLO DE OUTRA FORMA - eventoRepository.delete(eventoRepository.findById(id).get());
    }
    @GetMapping("/{id}")
    public Evento readOne (@PathVariable Integer id) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        if(eventoOptional.isPresent()){
            return eventoOptional.get();
        }
        throw new RuntimeException();
    }
    @GetMapping
    public List<Evento>  readAll () {
        return eventoRepository.findAll();
    }
}
