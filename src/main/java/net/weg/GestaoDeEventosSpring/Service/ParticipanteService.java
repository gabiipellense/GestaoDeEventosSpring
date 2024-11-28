package net.weg.GestaoDeEventosSpring.Service;

import lombok.AllArgsConstructor;
import net.weg.GestaoDeEventosSpring.Model.Participante;
import net.weg.GestaoDeEventosSpring.Repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParticipanteService {

    private ParticipanteRepository repository;
    private InscricaoService inscricaoService;
    public Participante cadastro(Participante participante) {
       return repository.save(participante);
    }

    public Participante editar(Integer id, Participante participante) {
        participante.setId(id);
        return repository.save(participante);
    }

    public Participante editarEmail(Integer id, String email) {
        Participante participante = buscar(id);
        participante.setEmail(email);
        return repository.save(participante);
    }

    public void remover(Integer id) {
        inscricaoService.removerPorIdParticipante(id);
        repository.deleteById(id);
    }

    public Participante buscar(Integer id) {
        Optional<Participante> optional = repository.findById(id);

        if(optional.isPresent()){
            return  optional.get();
        }
        throw new NoSuchElementException();
    }
    public Participante buscar (String  email) {
        Optional<Participante> optional = repository.findByEmail(email);

        if(optional.isPresent()){
            return optional.get();
        }
        throw new NoSuchElementException();
    }
    public List<Participante> buscar() {
        return repository.findAll();
    }


}
