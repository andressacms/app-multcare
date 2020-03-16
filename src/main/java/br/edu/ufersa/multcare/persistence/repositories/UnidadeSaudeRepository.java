package br.edu.ufersa.multcare.persistence.repositories;

import java.util.List;

import br.edu.ufersa.multcare.persistence.entities.UnidadeDeSaude;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;

public class UnidadeSaudeRepository extends AbstractReporitory<UnidadeDeSaude> 
{
	public UnidadeSaudeRepository(IDbContext context) 
	{
		super(context, UnidadeDeSaude.class);
	}
	
	public List<UnidadeDeSaude> findAllByUser () {
		return null; //TODO not implemented yet
	}
}
