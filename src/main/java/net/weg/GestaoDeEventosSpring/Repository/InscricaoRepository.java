package net.weg.GestaoDeEventosSpring.Repository;

import net.weg.GestaoDeEventosSpring.Model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
}
