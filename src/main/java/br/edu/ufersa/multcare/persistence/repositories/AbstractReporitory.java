package br.edu.ufersa.multcare.persistence.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;
import br.edu.ufersa.multcare.persistence.interfaces.IEntity;

public abstract class AbstractReporitory<T extends IEntity> 
{
	private IDbContext context;
	
	private Class<T> entityClass;
	
	protected IDbContext getContext() {
		return context;
	}
	
	protected void setContext(IDbContext context) {
		this.context = context;
	}
	
	public AbstractReporitory(IDbContext context, Class<T> entityClass) {
		this.setContext(context);
		this.entityClass = entityClass;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(int id) throws DbContextException 
	{
		return (T) this.getContext().findById(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DbContextException
	{
		TypedQuery<IEntity> q = this.getContext().query("SELECT e FROM "+entityClass.getSimpleName()+" as e");

		List<T> resultList = (List<T>) q.getResultList();
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(int pageNumber, int pageSize) throws DbContextException
	{
		int startRow = (pageNumber - 1) * pageSize;
		
		TypedQuery<IEntity> q = this.getContext().sqlQuery(
				"SELECT entity.* FROM "+entityClass.getSimpleName().toLowerCase()+" as entity LIMIT ? OFFSET ?",
				entityClass
		);
		
		q.setParameter(1, pageSize);
		q.setParameter(2, startRow);

		List<T> resultList = (List<T>) q.getResultList();
		return resultList;
	}
}
