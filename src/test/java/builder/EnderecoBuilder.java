package builder;

import br.com.questao01.dto.Endereco;

public class EnderecoBuilder {
	
	public static Endereco getEnderecoComCamposObrigatoriosPreenchidos() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Nome do Bairro");
		endereco.setCep("00000000");
		endereco.setCidade("Nome da Cidade");
		endereco.setComplemento("Nome do Complemento");
		endereco.setEstado("Nome do Estado");
		endereco.setNumero("999");
		endereco.setRua("Nome da Rua");
		return endereco;
	}
	
	public static Endereco getEnderecoComCampoRuaNaoPreenchido() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Nome do Bairro");
		endereco.setCep("00000000");
		endereco.setCidade("Nome da Cidade");
		endereco.setComplemento("Nome do Complemento");
		endereco.setEstado("Nome do Estado");
		endereco.setNumero("999");
		return endereco;
	}
}
