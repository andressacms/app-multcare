package br.edu.ufersa.multcare.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoricoAnalisesController {
	
	@RequestMapping("/avaliar-risco-drc")
    public String avaliarRiscoDRC() {
        return null;
    }
}
