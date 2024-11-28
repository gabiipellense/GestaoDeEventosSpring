package net.weg.GestaoDeEventosSpring.Service;

import lombok.AllArgsConstructor;
import net.weg.GestaoDeEventosSpring.Controller.dto.InscricaoRequestDTO;
import net.weg.GestaoDeEventosSpring.Model.Evento;
import net.weg.GestaoDeEventosSpring.Model.Inscricao;
import net.weg.GestaoDeEventosSpring.Repository.EventoRepository;
import net.weg.GestaoDeEventosSpring.Repository.InscricaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InscricaoService {

    private InscricaoRepository repository;
    private EventoService eventoService;
    public Inscricao cadastro(InscricaoRequestDTO dto) {
        Inscricao inscricao = dto.conversao()   ;
        return repository.save(inscricao);
    }

    public Inscricao edicao(Integer id, InscricaoRequestDTO dto) {
        Inscricao inscricao = dto.conversao();
        inscricao.setId(id);
        return repository.save(inscricao);
    }

    public Inscricao trocarEvento(Integer idInscricao, Integer idEvento) {
        Inscricao inscricao = buscarUmaInscricaoPorId(idInscricao);
        try {
            Evento evento = eventoService.buscar(idEvento);
            inscricao.setEvento(evento);
            return repository.save(inscricao);
        }
        catch (Exception e){
            throw new NoSuchElementException();
        }

    }
    public Inscricao buscarUmaInscricaoPorId(Integer idInscricao){
        Optional<Inscricao> optional = repository.findById(idInscricao);

        if(optional.isEmpty()){
            throw new NoSuchElementException();
        }
        return optional.get();
    }

    public List<Inscricao> buscarInscricoes() {
        return repository.findAll();
    }
    public void removerInscricao (Integer id){
        if(!repository.existsById(id)){
            throw new NoSuchElementException();
        }
        repository.deleteById(id);
    }

    public void removerPorIdParticipante(Integer id) {
        repository.deleteAllByParticipante_Id(id);
    }
    public List<Inscricao> buscarPorParticipante(Integer idParticipante) {
        return repository.findAllByParticipante_Id(idParticipante);
    }
    public List<Inscricao> buscarPorEvento(Integer idEvento) {
        return repository.findAllByEvento_Id(idEvento);
    }
}
