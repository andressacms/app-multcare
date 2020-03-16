package br.edu.ufersa.multcare.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.multcare.persistence.Repositories;
import br.edu.ufersa.multcare.persistence.entities.UnidadeDeSaude;

@RestController
public class RecomendacoesController {
	
	@RequestMapping("/recomendacao-unidade-saude")
    public List<UnidadeDeSaude> recomendarUnidadeSaude() {
		List<UnidadeDeSaude> unidadesDeSaude = Repositories.unidadesDeSaude.findAllByUser();
        return unidadesDeSaude;
    }
}
