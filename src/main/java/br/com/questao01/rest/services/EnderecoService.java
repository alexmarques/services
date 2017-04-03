package br.com.questao01.rest.services;

import java.net.URI;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.jboss.logging.Logger;

import br.com.questao01.dao.EnderecoDAO;
import br.com.questao01.dto.Endereco;
import br.com.questao01.exception.CEPInvalidoException;
import br.com.questao01.validators.CEPValidator;

@Path("/endereco")
@Consumes("application/json; charset=UTF-8")
@Produces("application/json; charset=UTF-8")
public class EnderecoService {
	
	private Logger logger = Logger.getLogger(EnderecoService.class);
	
	@Inject
	private EnderecoDAO enderecoDAO;
	
	@POST
	public Response incluir(@Valid Endereco endereco) {
		
		try {
			
			CEPValidator.getMock().isValido(endereco.getCep());
			
			if(endereco.getId() == null) {
				enderecoDAO.create(endereco);
			} else {
				enderecoDAO.update(endereco);
			}
			URI uri = UriBuilder.fromPath("endereco/{id}").build(endereco.getId());
			return Response.created(uri).entity(endereco).build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage(), e);
			Response error = Response.status(Status.INTERNAL_SERVER_ERROR)
					.encoding("UTF-8")
					.entity("Falha ao incluir endereco.").build();
			throw new WebApplicationException(error);
		} catch (CEPInvalidoException e) {
			Response error = Response.status(Status.BAD_REQUEST)
					.encoding("UTF-8")
					.entity(e.getMessage()).build();
			throw new WebApplicationException(error);
		}
	}
	
	@GET
	@Path("{id}")
	public Response obter(@PathParam("id") String id) {
		Endereco endereco;
		try {
			endereco = enderecoDAO.read(id);
			if(endereco == null) {
				return Response.status(Status.NOT_FOUND).build();
			}
			return Response.ok(endereco).build();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			Response error = Response.status(Status.INTERNAL_SERVER_ERROR)
					.encoding("UTF-8")
					.entity("Falha ao recuperar o endereco com o id: " + id).build();
			throw new WebApplicationException(error);
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") String id) {
		try {
			enderecoDAO.delete(id);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			Response error = Response.status(Status.INTERNAL_SERVER_ERROR)
					.encoding("UTF-8")
					.entity("Falha ao deletar o endereco com o id: " + id).build();
			throw new WebApplicationException(error);
		}
		return Response.ok().build();
	}
	
	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
}