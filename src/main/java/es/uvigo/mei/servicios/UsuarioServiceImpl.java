package es.uvigo.mei.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.mei.daos.UsuarioDAO;
import es.uvigo.mei.entidades.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public Usuario crear(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	@Transactional
	public Usuario modificar(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Usuario usuario) {
		usuarioDAO.delete(usuario);		
	}
	
	@Override
	@Transactional
	public Usuario buscarPorId(Long id) {
		return usuarioDAO.getOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarPorNombre(String nombre) {
		return usuarioDAO.findUsuarioByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		return usuarioDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarPorEmail(String email) {
		return usuarioDAO.findUsuarioByEmail(email);
	}
	
	
}
