package es.uvigo.mei.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.uvigo.mei.entidades.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	public List<Usuario> findUsuarioByNombre(String nombre);
    
	@Query("SELECT u FROM Usuario u WHERE u.email LIKE %?1")
	public List<Usuario> findUsuarioByEmail(String patron);
}
