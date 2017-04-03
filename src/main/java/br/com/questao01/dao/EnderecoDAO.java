package br.com.questao01.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

import br.com.questao01.dto.Endereco;

@RequestScoped
public class EnderecoDAO implements GenericDAO<Endereco> {
	
	@Resource(lookup="java:jboss/datasources/ServicesDS")
	private DataSource dataSource;
	
	public void create(Endereco endereco) throws SQLException {
		String sql = "insert into endereco (rua, cep, cidade, estado, numero, bairro, complemento) values (?,?,?,?,?,?,?)";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, endereco.getRua());
		ps.setString(2, endereco.getCep());
		ps.setString(3, endereco.getCidade());
		ps.setString(4, endereco.getEstado());
		ps.setString(5, endereco.getNumero());
		ps.setString(6, endereco.getBairro());
		ps.setString(7, endereco.getComplemento());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			endereco.setId(rs.getLong(1));
		}
	}

	public Endereco read(String id) throws SQLException {
		String sql = "select * from endereco where id = ?";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
		ps.setLong(1, Long.valueOf(id));
		ResultSet rs = ps.executeQuery();
		Endereco endereco = null;
		while(rs.next()) {
			endereco = new Endereco();
			endereco.setId(rs.getLong(1));
			endereco.setRua(rs.getString(2));
			endereco.setCep(rs.getString(3));
			endereco.setCidade(rs.getString(4));
			endereco.setEstado(rs.getString(5));
			endereco.setNumero(rs.getString(6));
			endereco.setBairro(rs.getString(7));
			endereco.setComplemento(rs.getString(8));
		}
		return endereco;
	}

	public void update(Endereco endereco) throws SQLException {
		if(endereco.getId() <= 0) {
			throw new SQLException("ID do endereço deve ser fornecido");
		}
		String sql = "update endereco set rua=?,cep=?,cidade=?,estado=?,numero=?,bairro=?,complemento=? where id=?";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
		ps.setString(1, endereco.getRua());
		ps.setString(2, endereco.getCep());
		ps.setString(3, endereco.getCidade());
		ps.setString(4, endereco.getEstado());
		ps.setString(5, endereco.getNumero());
		ps.setString(6, endereco.getBairro());
		ps.setString(7, endereco.getComplemento());
		ps.setLong(8, endereco.getId());
		ps.executeUpdate();
	}

	public void delete(String id) throws SQLException {
		String sql = "delete from endereco where id = ?";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
		ps.setLong(1, Long.parseLong(id));
		ps.executeUpdate();
	}
}