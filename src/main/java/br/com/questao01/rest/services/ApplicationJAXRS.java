package br.com.questao01.rest.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.questao01.rest.mapper.CamposObrigatoriosMapper;

public class ApplicationJAXRS extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(CEPService.class);
		classes.add(EnderecoService.class);
		classes.add(CamposObrigatoriosMapper.class);
		
		return classes;
	}
	
	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		return singletons;
	}
}