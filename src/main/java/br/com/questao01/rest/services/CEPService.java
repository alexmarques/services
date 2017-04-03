package br.com.questao01.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.questao01.dto.Endereco;
import br.com.questao01.exception.CEPInvalidoException;
import br.com.questao01.mocks.BuscaCepService;
import br.com.questao01.validators.CEPValidator;

@Path("/cep")
@Consumes("application/json; charset=UTF-8")
@Produces("application/json; charset=UTF-8")
public class CEPService {

	@GET
	@Path("{numero}")
	public Response buscar(@PathParam("numero") String cep) {
		
		Endereco endereco = null;
		
		try {
			
			endereco = buscarInformacoesDeCepNosCorreios(cep);

			if (endereco == null) {

				char cepCharArray[] = cep.toCharArray();

				for (int count = cepCharArray.length - 1; count >= 0; count--) {
					char value = cepCharArray[count];
					if (value != '0') {
						cepCharArray[count] = '0';
						endereco = buscarInformacoesDeCepNosCorreios(String.valueOf(cepCharArray));
						if (endereco != null) {
							break;
						}
					}
				}
			}
			
		} catch (CEPInvalidoException e) {
			Response error = Response.status(Status.BAD_REQUEST)
								.encoding("UTF-8")
								.entity(e.getMessage()).build();
			throw new WebApplicationException(error);
		}
				
		return Response.ok(endereco).build();
	}
	
	private Endereco buscarInformacoesDeCepNosCorreios(String cep) throws CEPInvalidoException {
		if(!CEPValidator.getMock().isValido(cep)) {
			throw new CEPInvalidoException("CEP Inválido");
		}
		
		Endereco endereco = BuscaCepService.getMock(cep).buscar(cep);
		
		return endereco;
	}
}
