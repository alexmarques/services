package br.com.questao01.mocks;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import br.com.questao01.dto.Endereco;

public class BuscaCepService {
	
	public Endereco buscar(String cep) {
		return new Endereco();
	}
	
	public static BuscaCepService getMock(String cep) {
		BuscaCepService mock = mock(BuscaCepService.class);
		when(mock.buscar("00000000")).thenReturn(getEndereco(cep));
		return mock;
	}
	
	private static Endereco getEndereco(String cep) {
		Endereco endereco = new Endereco();
		endereco.setId(1L);
		endereco.setCep(cep);
		endereco.setBairro("Nome do Bairoo");
		endereco.setCidade("Nome da Cidade");
		endereco.setEstado("Nome do Estado");
		endereco.setRua("Nome da Rua");
		endereco.setNumero("Número");
		return endereco;
	}
}