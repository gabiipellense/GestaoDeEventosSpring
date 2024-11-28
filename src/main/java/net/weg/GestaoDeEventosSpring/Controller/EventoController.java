package net.weg.GestaoDeEventosSpring.Controller;

import lombok.AllArgsConstructor;
import net.weg.GestaoDeEventosSpring.Model.Evento;
import net.weg.GestaoDeEventosSpring.Repository.EventoRepository;
import net.weg.GestaoDeEventosSpring.Service.EventoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@AllArgsConstructor
public class EventoController {
    private EventoService eventoService;
    @PostMapping
    public void create (@RequestBody Evento evento) {
        eventoService.cadastro(evento) ;
    }
    @PutMapping
    public void update (@RequestBody Evento evento) {
        eventoService.editar(evento) ;
    }
    @PatchMapping
    public void trocarData (@RequestParam Integer id, @RequestParam String data) {
        eventoService.alterarData(id, data);
    }
    @DeleteMapping("{id}")
    public void delete (@PathVariable Integer id) {
        eventoService.remover(id);
        //EXEMPLO DE OUTRA FORMA - eventoRepository.delete(eventoRepository.findById(id).get());
    }
    @GetMapping("/{id}")
    public Evento readOne (@PathVariable Integer id) {
        return eventoService.buscar(id);
    }
    @GetMapping
    public List<Evento>  readAll () {
        return eventoService.buscar();
    }

}
