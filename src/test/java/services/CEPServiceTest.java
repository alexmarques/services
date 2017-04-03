package services;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import br.com.questao01.dto.Endereco;
import junit.framework.TestCase;

public class CEPServiceTest extends TestCase {
	
	private WebTarget target;
	
	@Override
	protected void setUp() throws Exception {
		Client client = ClientBuilder.newClient();
		this.target = client.target("http://localhost:8080/services/cep/");
	}
	
	public void testBucarEnderecoComCEPInvalido() {
		try {
			this.target.path("98989898").request(MediaType.APPLICATION_JSON).get(Endereco.class);
		} catch(WebApplicationException e) {
			assertEquals(Status.BAD_REQUEST.getStatusCode(), e.getResponse().getStatus());
		}
	}

	public void testBuscarEnderecoComCEPValido() {
		Endereco endereco = this.target.path("99999999").request(MediaType.APPLICATION_JSON).get(Endereco.class);
		assertNotNull(endereco);
	}
	
}