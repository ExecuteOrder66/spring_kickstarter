package es.uvigo.mei.controladores;

import java.util.List;
import javax.validation.Valid;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.uvigo.mei.servicios.CampanhaService;
import es.uvigo.mei.entidades.Campanha;

@Controller
@RequestMapping("/campanhas")
public class CampanhasController {

	@Autowired
	CampanhaService campanhaService;
	
	@GetMapping
	public String prepararListarArticulos(Model modelo) {
		modelo.addAttribute("campanhas", campanhaService.buscarTodos());
		modelo.addAttribute("nombreCampanha", "");
		return "campanha/listado_campanhas";
	}
	
	@PostMapping
	public String actualizarListarCampanha(@RequestParam(required = false) String nombreCampanha,
			@RequestParam(required = false) Long idCreador, Model modelo) {
		List<Campanha> campanhas;
		if ((nombreCampanha != null) && !nombreCampanha.isEmpty()) {
			campanhas = campanhaService.buscarPorPatronNombreCampanha(nombreCampanha);
		} else if (idCreador != null) {
			campanhas = campanhaService.findCampanhaByCreador(idCreador);
		} else {
			campanhas = campanhaService.buscarTodos();
		}
		modelo.addAttribute("campanhas", campanhas);	
		return "campanha/listado_campanhas";
	}
	
	@GetMapping("nuevo")
	public ModelAndView prepararNuevoCampanha() {
		Campanha campanha = new Campanha();

		ModelAndView result = new ModelAndView();
		result.addObject("campanha", campanha);
		result.addObject("esNuevo", true);
		result.setViewName("campanha/editar_campanha");
		return result;
	}
	
	@PostMapping("nuevo")
	public String crearCampanha(@Valid @ModelAttribute Campanha campanha, BindingResult resultado) {
		if (!resultado.hasErrors()) {
			campanhaService.crear(campanha);
			return "redirect:/articulos";
		} else {
			return null;
		}
	}
	
	@GetMapping("{id}")
	public String prepararEditarCampanha(@PathVariable("id") Long id, Model modelo) {
		try {
			Campanha campanha = campanhaService.buscarPorId(id);
			modelo.addAttribute("campanha", campanha);
			modelo.addAttribute("esNuevo", false);		
			return "campanha/editar_campanha";
		} catch (EntityNotFoundException e) {
			modelo.addAttribute("error", "Campanha no encontrado");
			return "error";
		}
	}
	
	@PostMapping("{id}")
	public String actualizarArticulo(@Valid @ModelAttribute Campanha campanha, BindingResult resultado) {
		if (!resultado.hasErrors()) {
			campanhaService.modificar(campanha);
			return "redirect:/campanhas";
		} else {
			return null;
		}
	}
}
