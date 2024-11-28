package net.weg.GestaoDeEventosSpring.Repository;

import net.weg.GestaoDeEventosSpring.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByNome (String nome);
}
