package es.uvigo.mei.controladores;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.uvigo.mei.entidades.Usuario;
import es.uvigo.mei.servicios.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public String prepararListarUsuarios(Model modelo) {
		List<Usuario> usuarios = usuarioService.buscarTodos();
		modelo.addAttribute("usuarios", usuarios);
		modelo.addAttribute("nombreUsuario", "");
		modelo.addAttribute("apellidosUsuario", "");
		modelo.addAttribute("emailUsuario", "");
		return "usuarios/listado_usuarios";
	}
	
	/**
	 * @RequestParam captura los parámetros de la peticion (en este caso cuerpo del
	 *               POST) cuyo nombre coincida con el nombre de los parametros
	 */
	@PostMapping
	public String actualizarListarUsuarios(@RequestParam(required = false) String emailUsuario, 
			@RequestParam(required = false) String nombreUsuario, Model modelo) {
		List<Usuario> usuarios;
		
		if ((emailUsuario != null) && !emailUsuario.isEmpty()) {
			usuarios = usuarioService.buscarPorEmail(emailUsuario);
		} else if ((nombreUsuario != null) && !nombreUsuario.isEmpty()) {
			usuarios = usuarioService.buscarPorNombre(nombreUsuario);
		} else{
			usuarios = usuarioService.buscarTodos();
		}
		modelo.addAttribute("usuarios", usuarios);
		return "usuarios/listado_usuarios";
	}
	
	/**
	 * @PathVariable vincula el parametro a un segmento de la URI
	 */
	@GetMapping("{id}/eliminar")
	public String borrarUsuario(@PathVariable("id") Long id, Model modelo) {
		Usuario usuario = usuarioService.buscarPorId(id);
		if (usuario != null) {
			usuarioService.eliminar(usuario);
			return "redirect:/usuarios";
		} else {
			modelo.addAttribute("mensajeError", "Usuario no encontrado");
			return "error";
		}
	}
}
