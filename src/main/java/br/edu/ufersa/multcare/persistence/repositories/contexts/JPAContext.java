package br.edu.ufersa.multcare.persistence.repositories.contexts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;
import br.edu.ufersa.multcare.persistence.interfaces.IEntity;

public class JPAContext implements IDbContext {
	
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public JPAContext(String persistenceUnitName) 
	{		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	@Override
	public IEntity findById(Class<?> classe, int id) throws DbContextException 
	{
		try {
			IEntity entity = (IEntity) entityManager.find(classe, id);
			return entity;
		} catch (Exception e) {
			throw new DbContextException("Hibernate:findById: "+e.getMessage());
		}
	}

	@Override
	public void persist(IEntity entity) throws DbContextException 
	{
		try {
			if(!entityTransaction.isActive())
			{
				entityTransaction.begin();
			}
			entityManager.persist(entity);
		} catch (Exception e) {
			throw new DbContextException("Hibernate:persist: "+e.getMessage());
		}
	}

	@Override
	public void remove(IEntity entity) throws DbContextException 
	{
		try {
			if(!entityTransaction.isActive())
			{
				entityTransaction.begin();
			}
			entityManager.remove(entity);
		} catch (Exception e) {
			throw new DbContextException("Hibernate:remove: "+e.getMessage());
		}
	}

	@Override
	public void begin() throws DbContextException 
	{
		try {
			if(!entityTransaction.isActive())
			{
				entityTransaction.begin();
			}
		} catch (Exception e) {
			throw new DbContextException("Hibernate:begin: "+e.getMessage());
		}
	}

	@Override
	public void commit() throws DbContextException 
	{
		try {
			if(!entityTransaction.isActive())
			{
				entityTransaction.begin();
			}
			entityTransaction.commit();
		} catch (Exception e) {
			throw new DbContextException("Hibernate:commit: "+e.getMessage());
		}
	}

	@Override
	public void rollback() throws DbContextException {
		try {
			if(entityTransaction.isActive())
			{
				entityTransaction.rollback();
			}
		} catch (Exception e) {
			throw new DbContextException("Hibernate:rollback: "+e.getMessage());
		}
	}

	@Override
	public TypedQuery<IEntity> query(String query) throws DbContextException 
	{
		try {
			return (TypedQuery<IEntity>) entityManager.createQuery(query, IEntity.class);
		} catch (Exception e) {
			throw new DbContextException("Hibernate:query: "+e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public TypedQuery<IEntity> sqlQuery(String sql, Class<?> parseClass) throws DbContextException 
	{
		try {
			return (TypedQuery<IEntity>) entityManager.createNativeQuery(sql, parseClass);
		} catch (Exception e) {
			throw new DbContextException("Hibernate:sqlQuery: "+e.getMessage());
		}
	}
	
	@Override
	public Query sqlQuery(String sql) throws DbContextException 
	{
		try {
			return entityManager.createNativeQuery(sql);
		} catch (Exception e) {
			throw new DbContextException("Hibernate:sqlQuery: "+e.getMessage());
		}
	}

	@Override
	public void close() throws DbContextException 
	{
		try {
			entityManager.close();
		} catch (Exception e) {
			throw new DbContextException("Hibernate:close: "+e.getMessage());
		}
	}

	@Override
	public void flush(IEntity entity) throws DbContextException 
	{
		try {
			entityManager.flush();
		} catch (Exception e) {
			throw new DbContextException("Hibernate:flush: "+e.getMessage());
		}
	}

	@Override
	public void detach(IEntity entity) throws DbContextException {
		try {
			entityManager.detach(entity);
		} catch (Exception e) {
			throw new DbContextException("Hibernate:detach: "+e.getMessage());
		}
	}
}
