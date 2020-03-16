package br.edu.ufersa.multcare.persistence;

import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;
import br.edu.ufersa.multcare.persistence.interfaces.IEntity;
import br.edu.ufersa.multcare.persistence.repositories.AlergiaRepository;
import br.edu.ufersa.multcare.persistence.repositories.AnaliseRepository;
import br.edu.ufersa.multcare.persistence.repositories.ExameRepository;
import br.edu.ufersa.multcare.persistence.repositories.MedicamentoRepository;
import br.edu.ufersa.multcare.persistence.repositories.UnidadeSaudeRepository;
import br.edu.ufersa.multcare.persistence.repositories.UsuarioRepository;
import br.edu.ufersa.multcare.persistence.repositories.contexts.JPAContext;

public abstract class Repositories {
	
	private final static IDbContext context = new JPAContext("multcare-postgres");
	
	/** repositories **/
	public final static AlergiaRepository alergias = new AlergiaRepository(context);
	public final static AnaliseRepository analises = new AnaliseRepository(context);
	public final static ExameRepository exames = new ExameRepository(context);
	public final static MedicamentoRepository medicamentos = new MedicamentoRepository(context);
	public final static UsuarioRepository usuarios = new UsuarioRepository(context);
	public final static UnidadeSaudeRepository unidadesDeSaude = new UnidadeSaudeRepository(context);
	
	/** encapsulated context methods **/
	public static void persist(IEntity entity) throws DbContextException
	{
		context.persist(entity);
	}
	public static void remove(IEntity entity) throws DbContextException
	{
		context.remove(entity);
	}
	public static void detach(IEntity entity) throws DbContextException
	{
		context.detach(entity);
	}
	public static void commit() throws DbContextException
	{
		try {
			context.commit();
		} catch (Exception e) {
			context.rollback();
			throw e;
		}
	}
}
