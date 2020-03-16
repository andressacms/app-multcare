package br.edu.ufersa.multcare.persistence.repositories;

import br.edu.ufersa.multcare.persistence.entities.Medicamento;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;

public class MedicamentoRepository extends AbstractReporitory<Medicamento> 
{
	public MedicamentoRepository(IDbContext context) 
	{
		super(context, Medicamento.class);
	}
}
