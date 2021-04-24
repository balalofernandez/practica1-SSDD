package practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.repository.CultivoRepository;

@Controller
public class CultivosController {

	@Autowired
	private CultivoRepository repCultivos;
	
	@RequestMapping("/cultivos")
	public String cultivos(Model model) {
		
		model.addAttribute("carlos","Patata");
		
		return "/cultivos/mostrarCultivos";
	}
	
	

}
