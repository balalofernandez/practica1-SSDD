package practica1.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.model.Tratamiento;
import practica1.repository.TratamientoRepository;

@Controller
public class TratamientosController {
	@Autowired
	private TratamientoRepository repTratamientos;
	
	@PostConstruct
	public void init() {
		repTratamientos.save(new Tratamiento("Mangos", "Hierro", "9999", LocalDate.of(2021,7,5), LocalDate.of(2021,7,5), LocalDate.of(2021,7,9)));
		repTratamientos.save(new Tratamiento("Aguacates", "Azufre", "1234", LocalDate.of(2021,7,10), LocalDate.of(2021,7,15), LocalDate.of(2021,7,19)));
	}

	@RequestMapping("/tratamientos")
	public String tratamientos(
			@RequestParam(value="enviar",required=false) String enviar,
			//Los siguientes son urls que lee para hacer sorts.
			@RequestParam(required=false) Long tratamiento,
			@RequestParam(required=false) String cultivo,
			@RequestParam(required=false) String producto,
			@RequestParam(required=false) String numeroLote,
			@RequestParam(required=false) String fechaTratamiento,
			@RequestParam(required=false) String plazoReentrada,
			@RequestParam(required=false) String plazoRecoleccion,			
			Model model) {
		
		//CASO EN EL QUE NO HAY NINGUN PARAMETRO DE BUSQUEDA
		if(tratamiento != null && tratamiento > 0) {
			System.out.println(tratamiento);
			model.addAttribute("tratamientos",repTratamientos.getOne(tratamiento));
		}
		else if(cultivo != null && cultivo != "") {
			model.addAttribute("tratamientos",repTratamientos.findByCultivo(cultivo));
		}
		else if(producto != null && producto != "") {
			model.addAttribute("tratamientos",repTratamientos.findByCultivo(producto));
		}
		else if(numeroLote != null && numeroLote != "") {
			model.addAttribute("tratamientos",repTratamientos.findByCultivo(numeroLote));
		}
		else if(fechaTratamiento != null && fechaTratamiento != "") {
			model.addAttribute("tratamientos",repTratamientos.findByFechaTratamiento(LocalDate.parse(fechaTratamiento)));
		}
		else if(plazoReentrada != null && plazoReentrada != "") {
			model.addAttribute("tratamientos",repTratamientos.findByFechaTratamiento(LocalDate.parse(plazoReentrada)));
		}
		else if(plazoRecoleccion != null && plazoRecoleccion != "") {
			model.addAttribute("tratamientos",repTratamientos.findByFechaTratamiento(LocalDate.parse(plazoRecoleccion)));
		}
		else {
			model.addAttribute("tratamientos", repTratamientos.findAll());
		}
		
		return "/tratamientos/mostrarTratamientos";
	}
	
	
	//MODIFICAR TRATAMIENTO
	
	@RequestMapping("/modificarTratamiento")
	public String modificarTratamiento(
			@RequestParam long id,
			Model model) {
			
		model.addAttribute("tratamiento", repTratamientos.getOne(id));
		
		return "/tratamientos/modificarTratamiento";
	}
	
	@RequestMapping("/tratamientoModificado")
	public String tratamientoModificado(
			@RequestParam(value="enviar", required = false) String enviar,
			@RequestParam long id,
			Tratamiento tratamiento,
			Model model) {
		
		if(enviar != null) {
			Tratamiento trat = repTratamientos.getOne(id);
			trat.updateTratamiento(tratamiento);
			repTratamientos.save(trat);
		}
		model.addAttribute("path","tratamientos");
		model.addAttribute("mensaje","Se ha modificado el tratamiento con éxito");
		
		return "ModificadoConExito";
	}
	
	//NUEVO TRATAMIENTO
	
	@RequestMapping("/insertarTratamiento")
	public String tratamientos(
			Model model) {
					
		return "/tratamientos/insertarTratamiento";
	}
	
	@RequestMapping("/nuevoTratamiento")
	public String nuevoTratamiento(
			@RequestParam(value="enviar", required = false) String enviar,
			Tratamiento tratamiento,
			Model model) {
		
		if(enviar != null) {
			repTratamientos.save(tratamiento);
		}
		model.addAttribute("path","tratamientos");
		model.addAttribute("mensaje","Se ha insertado el tratamiento con éxito");
		
		return "InsertadoConExito.html";
	}
	
}
