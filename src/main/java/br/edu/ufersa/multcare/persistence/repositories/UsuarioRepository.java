package br.edu.ufersa.multcare.persistence.repositories;

import javax.persistence.TypedQuery;

import br.edu.ufersa.multcare.persistence.entities.Usuario;
import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;
import br.edu.ufersa.multcare.persistence.interfaces.IEntity;

public class UsuarioRepository extends AbstractReporitory<Usuario>
{
	public UsuarioRepository(IDbContext context) 
	{
		super(context, Usuario.class);
	}

	public Usuario findByUsername(String username) throws DbContextException 
	{
		TypedQuery<IEntity> query = this.getContext().sqlQuery(
			"SELECT u.* FROM usuario AS u WHERE u.usuario = ? LIMIT 1",
			Usuario.class
		);
		
		query.setParameter(1, username.toLowerCase());
		
		return (Usuario) query.getSingleResult();
	}
}
