package net.weg.GestaoDeEventosSpring.Repository;

import net.weg.GestaoDeEventosSpring.Model.Inscricao;
import net.weg.GestaoDeEventosSpring.Model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
    void deleteAllByParticipante_Id(Integer idParticipante);
    List<Inscricao> findAllByParticipante_Id(Integer id);

    List<Inscricao> findAllByEvento_Id(Integer idEvento);
}
