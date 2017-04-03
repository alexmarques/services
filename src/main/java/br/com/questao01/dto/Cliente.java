package br.com.questao01.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Cliente implements Serializable{
	
	private long id;
	private String nome;
	private List<Endereco> enderecos;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public void addEndereco(Endereco endereco) {
		if(this.enderecos == null) {
			this.enderecos = new ArrayList<Endereco>();
		}
		this.enderecos.add(endereco);
	}
}