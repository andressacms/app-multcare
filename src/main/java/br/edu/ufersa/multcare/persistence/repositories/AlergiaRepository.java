package br.edu.ufersa.multcare.persistence.repositories;

import br.edu.ufersa.multcare.persistence.entities.Alergia;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;

public class AlergiaRepository extends AbstractReporitory<Alergia>
{
	public AlergiaRepository(IDbContext context) 
	{
		super(context, Alergia.class);
	}
}
