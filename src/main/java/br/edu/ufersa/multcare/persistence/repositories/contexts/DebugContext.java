package br.edu.ufersa.multcare.persistence.repositories.contexts;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;
import br.edu.ufersa.multcare.persistence.interfaces.IDbContext;
import br.edu.ufersa.multcare.persistence.interfaces.IEntity;

public class DebugContext implements IDbContext {

	@Override
	public IEntity findById(Class<?> classe, int id) throws DbContextException {
		System.out.println("Debug: buscando '"+classe+", id "+id);
		return null;
	}

	@Override
	public void persist(IEntity entity) throws DbContextException {
		System.out.println("Debug: persistir '"+entity);
	}

	@Override
	public void remove(IEntity entity) throws DbContextException {
		System.out.println("Debug: remover '"+entity);
	}

	@Override
	public void begin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypedQuery<IEntity> query(String query) throws DbContextException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush(IEntity entity) throws DbContextException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypedQuery<IEntity> sqlQuery(String sql, Class<?> parseClass) throws DbContextException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void detach(IEntity entity) throws DbContextException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Query sqlQuery(String sql) throws DbContextException {
		// TODO Auto-generated method stub
		return null;
	}

}
