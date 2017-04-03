package br.com.questao01.validators;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import br.com.questao01.exception.CEPInvalidoException;

public class CEPValidator {

	public boolean isValido(String cep) throws CEPInvalidoException {
		return false;
	}
	
	public static CEPValidator getMock() {
		CEPValidator mock = mock(CEPValidator.class);
		when(mock.isValido("99999990")).thenReturn(true);
		when(mock.isValido("99999900")).thenReturn(true);
		when(mock.isValido("99999000")).thenReturn(true);
		when(mock.isValido("99990000")).thenReturn(true);
		when(mock.isValido("99900000")).thenReturn(true);
		when(mock.isValido("99000000")).thenReturn(true);
		when(mock.isValido("90000000")).thenReturn(true);
		when(mock.isValido("00000000")).thenReturn(true);
		when(mock.isValido("99999999")).thenThrow(new CEPInvalidoException("CEP inválido."));
		return mock;
	}
}