package es.uvigo.mei.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.mei.daos.CampanhaDAO;
import es.uvigo.mei.daos.UsuarioDAO;
import es.uvigo.mei.entidades.Campanha;

@Service
public class CampanhaServiceImpl implements CampanhaService {
	@Autowired
	CampanhaDAO campanhaDAO;

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	@Transactional
	public Campanha crear(Campanha campanha) {
		return campanhaDAO.save(campanha);
	}

	@Override
	@Transactional
	public Campanha modificar(Campanha campanha) {
		return campanhaDAO.save(campanha);
	}

	@Override
	@Transactional
	public void eliminar(Campanha campanha) {
		campanhaDAO.delete(campanha);
	}

	@Override
	@Transactional(readOnly = true)
	public Campanha buscarPorId(Long id) {
		return campanhaDAO.getOne(id);
	}
	
	@Override
	@Transactional
	public List<Campanha> buscarPorPatronNombreCampanha(String patronNombre) {
		return campanhaDAO.findCampanhaByPatronNombreCampanha(patronNombre);
	}

	@Override
	@Transactional
	public List<Campanha> buscarTodos() {
		return campanhaDAO.findAll();
	}

	@Override
	@Transactional
	public List<Campanha> findCampanhaByCreador(Long idCreador) {
		return campanhaDAO.findCampanhaByCreador(idCreador);
	}

}
