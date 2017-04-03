package br.com.questao01.rest.mapper;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CamposObrigatoriosMapper implements ExceptionMapper<ValidationException> {

	public Response toResponse(ValidationException exception) {
		return Response.status(Status.CONFLICT).entity("Campos: Rua, CEP, Cidade, Estado, Numero s�o de preenchimento obrigat�rios.").encoding("UTF-8").build();
	}
}