package br.edu.ufersa.multcare.persistence.repositories;

import br.edu.ufersa.multcare.persistence.entities.Exame;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;

public class ExameRepository extends AbstractReporitory<Exame> 
{
	public ExameRepository(IDbContext context) 
	{
		super(context, Exame.class);
	}
}
