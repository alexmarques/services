package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.questao01.dto.Endereco;
import builder.EnderecoBuilder;
import junit.framework.TestCase;

public class EnderecoServiceTest extends TestCase {
	
	private WebTarget target;
	
	@Override
	protected void setUp() throws Exception {
		Client client = ClientBuilder.newClient();
		this.target = client.target("http://localhost:8080/services/endereco");
	}
	
	public void testInclusaoDeEnderecoValido() {
		Endereco endereco = EnderecoBuilder.getEnderecoComCamposObrigatoriosPreenchidos();
		Response response = this.target.request(MediaType.APPLICATION_JSON).post(Entity.json(endereco));
		assertEquals(response.getStatus(), Status.CREATED.getStatusCode());
	}
	
	public void testInclusaoDeEnderecoComCampoRuaNaoPreenchido() {
		Endereco endereco = EnderecoBuilder.getEnderecoComCampoRuaNaoPreenchido();
		Response response = this.target.request(MediaType.APPLICATION_JSON).post(Entity.json(endereco));
		assertEquals(response.getStatus(), Status.CONFLICT.getStatusCode());
	}
}