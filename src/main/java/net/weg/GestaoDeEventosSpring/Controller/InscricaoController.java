package net.weg.GestaoDeEventosSpring.Controller;

import net.weg.GestaoDeEventosSpring.Controller.dto.InscricaoRequestDTO;
import net.weg.GestaoDeEventosSpring.Model.Inscricao;
import net.weg.GestaoDeEventosSpring.Service.InscricaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    private InscricaoService service;

    @PostMapping
    public ResponseEntity<Inscricao> cadastro (@RequestBody InscricaoRequestDTO dto) {
        Inscricao inscricao = service.cadastro(dto);
    }
}
