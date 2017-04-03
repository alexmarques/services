package br.com.questao01.dao;

import java.sql.SQLException;

public interface GenericDAO<T> {
	
	public void create(T t) throws SQLException;
	public T read(String id) throws SQLException;
	public void update(T t) throws SQLException;
	public void delete(String id) throws SQLException;

}
