package practica1.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.model.Cultivo;
import practica1.model.ProductoFitosanitario;
import practica1.model.Tratamiento;
import practica1.repository.CultivoRepository;
import practica1.repository.ProductoFitosanitarioRepository;
import practica1.repository.TratamientoRepository;

@Controller
public class TratamientosController {
	@Autowired
	private TratamientoRepository repTratamientos;
	@Autowired
	private CultivoRepository repCultivos;
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
				
	@PostConstruct
	public void init() {
		Cultivo cultivo1 = new Cultivo("Mango", "Osteen", LocalDate.of(2020,1,5),"Málaga",new ArrayList<>());
		Cultivo cultivo2 = new Cultivo("Papaya", "Maña", LocalDate.of(2020,2,28), "Zaragoza", new ArrayList<>());
		Cultivo cultivo3 = new Cultivo("Fresa", "Bonita", LocalDate.of(2020,5,30), "Jaén", new ArrayList<>());
		Cultivo cultivo4 = new Cultivo("Granada", "Fragmentación", LocalDate.of(2020,5,5), "Granada", new ArrayList<>());
		Cultivo cultivo5 = new Cultivo("Alcachofa", "Flatulenta", LocalDate.of(2020,12,4), "Soria", new ArrayList<>());
		Cultivo cultivo6 = new Cultivo("Calabaza", "Gorda", LocalDate.of(2020,10,4), "Andorra", new ArrayList<>());
		ProductoFitosanitario producto1 = new ProductoFitosanitario("Hierro", 4, 10);
		ProductoFitosanitario producto2 = new ProductoFitosanitario("Azufre", 3, 5);
		ProductoFitosanitario producto3 = new ProductoFitosanitario("Fosfato de Hierro", 7, 3);
		ProductoFitosanitario producto4 = new ProductoFitosanitario("Nitrato de Amonio", 4);
		ProductoFitosanitario producto5 = new ProductoFitosanitario("Sulfato de Cobre");
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
			model.addAttribute("tratamientos", repTratamientos.findByCultivoEspecie(cultivo));
		}
		else if(producto != null && producto != "" ) {
			model.addAttribute("tratamientos", repTratamientos.findByProductoNombre(producto));
		}
		else if(numeroLote != null && numeroLote != "") {
			model.addAttribute("tratamientos",repTratamientos.findByNumeroLote(numeroLote));
		}
		else if(fechaTratamiento != null && fechaTratamiento != "") {
			model.addAttribute("tratamientos",repTratamientos.findByFechaTratamiento(LocalDate.parse(fechaTratamiento)));
		}
		else if(plazoReentrada != null && plazoReentrada != "") {
			model.addAttribute("tratamientos",repTratamientos.findByFinPlazoReentrada(LocalDate.parse(plazoReentrada)));
		}
		else if(plazoRecoleccion != null && plazoRecoleccion != "") {
			model.addAttribute("tratamientos",repTratamientos.findByFinPlazoRecoleccion(LocalDate.parse(plazoRecoleccion)));
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
