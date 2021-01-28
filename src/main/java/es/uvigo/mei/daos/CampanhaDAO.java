package es.uvigo.mei.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.uvigo.mei.entidades.Campanha;

public interface CampanhaDAO extends JpaRepository<Campanha, Long>{
	public List<Campanha> findCampanhaByCreador(Long idCreador);
    
	@Query("SELECT c FROM Campanha c WHERE c.nombreCampanha LIKE %?1")
	public List<Campanha> findCampanhaByPatronNombreCampanha(String patronNombreCampanha);
}
