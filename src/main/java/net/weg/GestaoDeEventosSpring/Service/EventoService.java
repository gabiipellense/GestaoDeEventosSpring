package net.weg.GestaoDeEventosSpring.Service;

import lombok.AllArgsConstructor;
import net.weg.GestaoDeEventosSpring.Model.Evento;
import net.weg.GestaoDeEventosSpring.Repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EventoService {
    private EventoRepository repository;

    public Evento cadastro (Evento evento){
        return repository.save(evento);
    }
    public Evento editar ( Evento evento){
        if (repository.existsById(evento.getId())){
            return repository.save(evento);
        }
        throw new NoSuchElementException();
    }
    public Evento alterarData (Integer id , String data){
        Evento evento = repository.findById(id).get();
        evento.setData(data);
        return repository.save(evento);
    }
    public void remover (Integer id) {
        if(!repository.existsById(id)){
            throw new NoSuchElementException();
        }
        repository.deleteById(id);
    }
    public Evento buscar(Integer id){
        return repository.findById(id).get();
    }
    public List<Evento> buscar(){
        return repository.findAll();
    }
}
