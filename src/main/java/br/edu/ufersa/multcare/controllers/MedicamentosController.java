package br.edu.ufersa.multcare.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.multcare.persistence.Repositories;
import br.edu.ufersa.multcare.persistence.entities.Medicamento;
import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;

@RestController
public class MedicamentosController {
	
	@RequestMapping("/medicamentos/adicionar")
    public String adicionar() {
        return null;
    }
	
	@RequestMapping("/medicamentos/alterar")
    public String alterar(@RequestParam Map<String,String> allRequestParams) throws DbContextException {

		String id  = allRequestParams.get("id");
		
		Medicamento medicamento = Repositories.medicamentos.findById(Integer.parseInt(id));
		if(medicamento == null) {
        	return "not found";
        }
        
        String nome  = allRequestParams.get("nome");
        String dataInicial = allRequestParams.get("dataInicial");
        String dataFinal = allRequestParams.get("dataFinal");
        String frequencia = allRequestParams.get("frequencia");
        String hora = allRequestParams.get("hora");
        String quantidadeDiaria = allRequestParams.get("quantidadeDiaria");
        String tipo = allRequestParams.get("tipo");
        String totalMedicamento = allRequestParams.get("totalMedicamento");
        
        medicamento.setNome(nome);
        medicamento.setDataInicial(Date.valueOf(dataInicial));
        medicamento.setDataFinal(Date.valueOf(dataFinal));
        medicamento.setFrequencia(Integer.parseInt(frequencia));
        medicamento.setHora(hora);
        medicamento.setNome(nome);
        medicamento.setQuantidadeDiaria(Integer.parseInt(quantidadeDiaria));
        medicamento.setTipo(tipo);
        medicamento.setTotalMedicamento(Integer.parseInt(totalMedicamento));
        
        Repositories.persist(medicamento);
        
        return "ok";
    }
	
	@RequestMapping("/medicamentos/excluir")
    public String excluir(@RequestParam int id) throws DbContextException {
		Medicamento medicamento = Repositories.medicamentos.findById(id);
        if(medicamento == null) {
        	return "not found";
        }
        
        Repositories.remove(medicamento);
        return "ok";
    }
	
	@RequestMapping("/medicamentos/listar")
    public List<Medicamento> listar() throws DbContextException {
		List<Medicamento> medicamentos = Repositories.medicamentos.findAll();
        return medicamentos;
    }
}
