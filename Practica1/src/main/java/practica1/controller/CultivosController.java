package practica1.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.model.Cultivo;
import practica1.model.Tratamiento;
import practica1.repository.CultivoRepository;

@Controller
public class CultivosController {
	@Autowired
	private CultivoRepository repCultivos;
	
	@PostConstruct
	public void init() {
		Cultivo cultivo1 = new Cultivo("Mango", "Osteen", LocalDate.of(2020,1,5),"Málaga",new ArrayList<>());
		Cultivo cultivo2 = new Cultivo("Papaya", "Maña", LocalDate.of(2020,2,28), "Zaragoza", new ArrayList<>());
		Cultivo cultivo3 = new Cultivo("Fresa", "Bonita", LocalDate.of(2020,5,30), "Jaén", new ArrayList<>());
		Cultivo cultivo4 = new Cultivo("Granada", "Fragmentación", LocalDate.of(2020,5,5), "Granada", new ArrayList<>());
		Cultivo cultivo5 = new Cultivo("Alcachofa", "Flatulenta", LocalDate.of(2020,12,4), "Soria", new ArrayList<>());
		Cultivo cultivo6 = new Cultivo("Calabaza", "Gorda", LocalDate.of(2020,10,4), "Andorra", new ArrayList<>());
	}

	@RequestMapping("/cultivos")
	public String cultivos(
			@RequestParam(value="enviar",required=false) String enviar,
			@RequestParam(required=false) Long cultivo,
			@RequestParam(required=false) String especie,
			@RequestParam(required=false) String variedad,
			@RequestParam(required=false) String fechaPlantacion,
			@RequestParam(required=false) String zona,			
			Model model) {
		
		//CASO EN EL QUE NO HAY NINGUN PARAMETRO DE BUSQUEDA
		if(cultivo != null && cultivo > 0) {
			System.out.println(cultivo);
			model.addAttribute("cultivos",repCultivos.getOne(cultivo));
		}
		else if(especie != null && especie != "") {
			model.addAttribute("cultivos",repCultivos.findByEspecie(especie));
		}
		else if(variedad != null && variedad != "") {
			model.addAttribute("cultivos",repCultivos.findByVariedad(variedad));
		}
		else if(fechaPlantacion != null && fechaPlantacion != "") {
			model.addAttribute("cultivos",repCultivos.findByFechaPlantacion(LocalDate.parse(fechaPlantacion)));
		}
		else if(zona != null && zona != "") {
			model.addAttribute("cultivos",repCultivos.findByZona(zona));
		}
		else {
			model.addAttribute("cultivos", repCultivos.findAll());
		}
		
		return "/cultivos/mostrarCultivos";
	}
	
	
	//MODIFICAR CULTIVO
	
	@RequestMapping("/modificarCultivo")
	public String modificarCultivo(
			@RequestParam long id,
			Model model) {
			
		model.addAttribute("cultivo", repCultivos.getOne(id));
		
		return "/cultivos/modificarCultivo";
	}
	
	@RequestMapping("/cultivoModificado")
	public String cultivoModificado(
			@RequestParam(value="enviar", required = false) String enviar,
			@RequestParam long id,
			Cultivo cultivo,
			Model model) {
		
		if(enviar != null) {
			Cultivo cult = repCultivos.getOne(id);
			cult.updateCultivo(cultivo);
			repCultivos.save(cult);
		}
		model.addAttribute("path","cultivos");
		model.addAttribute("mensaje","Se ha modificado el cultivo con éxito");
		
		return "ModificadoConExito";
	}
	
	//NUEVO CULTIVO
	
	@RequestMapping("/insertarCultivo")
	public String cultivos(
			Model model) {
					
		return "/cultivos/nuevoCultivo";
	}
	
	@RequestMapping("/nuevoCultivo")
	public String nuevoCultivo(
			@RequestParam(value="enviar", required = false) String enviar,
			Cultivo cultivo,
			Model model) {
		
		if(enviar != null) {
			repCultivos.save(cultivo);
		}
		model.addAttribute("path","cultivos");
		model.addAttribute("mensaje","Se ha insertado el cultivo con éxito");
		
		return "InsertadoConExito.html";
	}
	
}
