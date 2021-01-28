package es.uvigo.mei;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import es.uvigo.mei.daos.CampanhaDAO;
import es.uvigo.mei.daos.UsuarioDAO;
import es.uvigo.mei.entidades.Usuario;
import es.uvigo.mei.entidades.Campanha;

@SpringBootApplication
public class KickstarterApplication {
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	CampanhaDAO campanhaDAO;

	public static void main(String[] args) {
		SpringApplication.run(KickstarterApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario("pedro", "martinez", "pmartinez@gmail.com");
    	u1 = usuarioDAO.save(u1);
    	Usuario u2 = new Usuario("maria", "rodriguez", "mrdgz@hotmail.es");
    	u2 = usuarioDAO.save(u2);
    	
    	campanhaDAO.save(new Campanha(u1, "Restaurante Manolo",new Date("04/12/2019"), new Date("05/03/2020"), new Long(10000)));
    	campanhaDAO.save(new Campanha(u2, "Paintball EXTREMO", new Date("05/10/2020"), new Date("06/12/2020"), new Long (25000)));
    	campanhaDAO.save(new Campanha(u1, "Disco Stu", new Date("03/01/2021"), new Date("04/03/2021"), new Long(3000)));
    	
    	List<Campanha> campanhas = campanhaDAO.findAll();
    	System.out.println("Todos las campañas");
	    for (Campanha c: campanhas) {
	    	System.out.println(">> "+c.toString());	    	
	    }
	    
	    System.out.println("Campanhas lanzadas por Pedro Martinez");
	    campanhas = campanhaDAO.findCampanhaByCreador(u1.getId());
	    for (Campanha c: campanhas) {
	    	System.out.println(">> "+c.toString());	    	
	    }
	    
	    System.out.println("Campanhas con paintball en el titulo");
	    campanhas = campanhaDAO.findCampanhaByPatronNombreCampanha("paintball");
	    for (Campanha c: campanhas) {
	    	System.out.println(">>"+ c.toString());
	    }
	    
	}
	
}
