package es.uvigo.mei.controladores.conversores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.uvigo.mei.entidades.Campanha;
import es.uvigo.mei.servicios.CampanhaService;

@Component
public class ConversorUsuario implements Converter<String, Campanha>{
	@Autowired
	private CampanhaService campanhaService;

	@Override
	public Campanha convert(String arg) {
		Long id = Long.parseLong(arg);
		return campanhaService.buscarPorId(id);
	}
}
