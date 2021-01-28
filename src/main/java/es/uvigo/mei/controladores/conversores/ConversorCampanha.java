package es.uvigo.mei.controladores.conversores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.uvigo.mei.entidades.Usuario;
import es.uvigo.mei.servicios.UsuarioService;

@Component
public class ConversorCampanha implements Converter<String, Usuario> {
	

		@Autowired
		private UsuarioService usuarioService;

		@Override
		public Usuario convert(String arg) {
			Long id = Long.parseLong(arg);
			return usuarioService.buscarPorId(id);
		}
}
