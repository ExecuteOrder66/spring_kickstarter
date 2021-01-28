package es.uvigo.mei.servicios;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.uvigo.mei.entidades.Campanha;

public interface CampanhaService {

	public Campanha crear(Campanha campanha);
	public Campanha modificar(Campanha campanha);
	public void eliminar(Campanha campanha);
	public Campanha buscarPorId(Long id);
	public List<Campanha> buscarPorPatronNombreCampanha(String patronNombre);
	public List<Campanha> buscarTodos();
	public List<Campanha> findCampanhaByCreador(Long idCreador);
}