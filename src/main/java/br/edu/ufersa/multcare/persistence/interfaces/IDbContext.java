package br.edu.ufersa.multcare.persistence.interfaces;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;

public interface IDbContext {
	public IEntity findById(Class<?> classe, int id) throws DbContextException;
	public void begin() throws DbContextException;
	public void commit() throws DbContextException;
	public void rollback() throws DbContextException;
	public void close() throws DbContextException;
	public TypedQuery<IEntity> query(String query) throws DbContextException;
	public TypedQuery<IEntity> sqlQuery(String sql, Class<?> parseClass) throws DbContextException;
	public void persist(IEntity entity) throws DbContextException;
	public void remove(IEntity entity) throws DbContextException;
	public void flush(IEntity entity) throws DbContextException;
	public void detach(IEntity entity) throws DbContextException;
	public Query sqlQuery(String sql) throws DbContextException;
}
