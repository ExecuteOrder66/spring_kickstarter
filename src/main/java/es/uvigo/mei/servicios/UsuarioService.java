package es.uvigo.mei.servicios;

import java.util.List;

import es.uvigo.mei.entidades.Usuario;

public interface UsuarioService {
	
	public Usuario crear(Usuario usuario);
	public Usuario modificar(Usuario usuario);
	public void eliminar(Usuario usuario);
	public Usuario buscarPorId(Long id);
	public List<Usuario> buscarPorNombre(String nombre);
	public List<Usuario> buscarTodos();
	public List<Usuario> buscarPorEmail(String email);
}
