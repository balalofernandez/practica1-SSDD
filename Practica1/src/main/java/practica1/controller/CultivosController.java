package practica1.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.model.Cultivo;
import practica1.repository.CultivoRepository;

@Controller
public class CultivosController {
	@Autowired
	private CultivoRepository repCultivos;
	
	@PostConstruct
	public void init() {
		repCultivos.save(new Cultivo());
		repCultivos.save(new Cultivo());
		repCultivos.save(new Cultivo());
		repCultivos.save(new Cultivo());
		repCultivos.save(new Cultivo());
		repCultivos.save(new Cultivo());
	}

	@RequestMapping("/cultivos")
	public String cultivos(
			@RequestParam(value="enviar",required=false) String enviar,
			//Los siguientes son urls que lee para hacer sorts.
			@RequestParam(required=false) Long cultivo,
			@RequestParam(required=false) String especie,
			@RequestParam(required=false) String variedad,
			@RequestParam(required=false) String fechaPlantacion,
			@RequestParam(required=false) String zona,			
			Model model) {
		
		//CASO EN EL QUE NO HAY NINGUN PARAMETRO DE BUSQUEDA
		if(tratamiento != null && tratamiento > 0) {
			System.out.println(cultivo);
			model.addAttribute("cultivos",repCultivos.getOne(cultivo));
		}
		else if(especie != null && especie != "") {
			model.addAttribute("cultivos",repCultivos.findByEspecie(especie));
		}
		else if(variedad != null && variedad != "") {
			model.addAttribute("cultivos",repCultivos.findByProducto(producto));
		}
		else if(fechaPlantacion != null && fechaPlantacion != "") {
			model.addAttribute("cultivos",repCultivos.findByFechaPlantacion(LocalDate.parse(fechaPlantacion)));
		}
		else if(zona != null && zona != "") {
			model.addAttribute("cultivos",repCultivos.findByZona(zona));
		}
		else if(tartamientos != null && tratamientos != "") {
			model.addAttribute("cultivos",repCultivos.findByTratamiento(tratamiento));
		}
		else {
			model.addAttribute("cultivos", repCultivos.findAll());
		}
		
		return "/cultivos/mostrarCultivos";
	}
	
	
	//MODIFICAR TRATAMIENTO
	
	@RequestMapping("/modificarCultivo")
	public String modificarCultivo(
			@RequestParam long id,
			Model model) {
			
		model.addAttribute("cultivo", repCultivos.getOne(id));
		
		return "/cultivos/mostrarCultivos";
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
		
		model.addAttribute("mensaje","Se ha modificado el cultivo con éxito");
		
		return "ModificadoConExito";
	}
	
	//NUEVO CULTIVO
	
	@RequestMapping("/insertarCultivo")
	public String cultivos(
			Model model) {
					
		return "/cultivos/insertarCultivo";
	}
	
	@RequestMapping("/nuevoCultivo")
	public String nuevoCultivo(
			@RequestParam(value="enviar", required = false) String enviar,
			Cultivo cultivo,
			Model model) {
		
		if(enviar != null) {
			repCultivos.save(cultivo);
		}
		
		model.addAttribute("mensaje","Se ha insertado el cultivo con éxito");
		
		return "InsertadoConExito.html";
	}
	
}
