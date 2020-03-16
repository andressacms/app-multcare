package br.edu.ufersa.multcare.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.multcare.persistence.Repositories;
import br.edu.ufersa.multcare.persistence.entities.Analise;
import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;

@RestController
public class AnaliseDeRiscoDeDRCController {
	
	@RequestMapping("/consultar-historico-analises")
    public String consultarHistoricoAnalises() throws DbContextException {
		List<Analise> analises = Repositories.analises.findAll();
		
		// validar
		
        return null;
    }
}
