package br.edu.ufersa.multcare.persistence.repositories;

import br.edu.ufersa.multcare.persistence.entities.Analise;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;

public class AnaliseRepository extends AbstractReporitory<Analise>
{
	public AnaliseRepository(IDbContext context) 
	{
		super(context, Analise.class);
	}
}
