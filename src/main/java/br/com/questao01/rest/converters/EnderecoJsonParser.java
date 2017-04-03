package br.com.questao01.rest.converters;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.questao01.dto.Endereco;

public class EnderecoJsonParser {
	
	private Endereco endereco;
	
	public EnderecoJsonParser(String jsonEndereco) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		this.endereco = mapper.readValue(jsonEndereco, Endereco.class);
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}

}
