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
		ProductoFitosanitario producto4 = new ProductoFitosanitario("Nitrato de Amonio", 4);//Plazo de recoleccion pero no de entrada
		ProductoFitosanitario producto5 = new ProductoFitosanitario("Sulfato de Cobre");
		Tratamiento t1 = new Tratamiento(cultivo1,producto4,"ES5165",LocalDate.of(2020,4,5));
		Tratamiento t2 = new Tratamiento(cultivo1,producto1,"ES4816",LocalDate.of(2020,4,5));
		Tratamiento t3 = new Tratamiento(cultivo1,producto2,"ES8816",LocalDate.of(2020,4,5));
		cultivo1.setTratamientos(new ArrayList<Tratamiento>(Arrays.asList(t1,t2,t3)));
		Tratamiento t4 = new Tratamiento(cultivo2,producto1,"AS4719",LocalDate.of(2020,8,5));
		Tratamiento t5 = new Tratamiento(cultivo2,producto3,"JK4194",LocalDate.of(2020,3,23));
		cultivo2.setTratamientos(new ArrayList<Tratamiento>(Arrays.asList(t4,t5)));
		Tratamiento t6 = new Tratamiento(cultivo3,producto1,"JK4194",LocalDate.of(2020,11,5));
		cultivo3.addTratamientos(t6);
		Tratamiento t7 = new Tratamiento(cultivo4,producto1,"PP1654",LocalDate.of(2020,10,9));
		cultivo4.addTratamientos(t7);
		Tratamiento t8 = new Tratamiento(cultivo5,producto5,"RS1784",LocalDate.of(2020,2,22));
		cultivo5.addTratamientos(t8);
		repCultivos.saveAll(new ArrayList<Cultivo>(Arrays.asList(cultivo1,cultivo2,cultivo3,cultivo4,cultivo5,cultivo6)));
		repProductos.saveAll(new ArrayList<ProductoFitosanitario>(Arrays.asList(producto1,producto2,producto3,producto4,producto5)));
		repTratamientos.saveAll(new ArrayList<Tratamiento>(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8)));
		
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
		else if(fechaTratamiento != null && fechaTratamiento !="") {
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
	
	//ORDENAR TRATAMIENTOS
	@RequestMapping(value="/ordenaTratamientos")
	public String ordenaTratamientos(@RequestParam String por,Model model) {
		switch(por) {
		case "AI":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByIdTratamientoAsc());
			break;
		case "DI":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByIdTratamientoDesc());
			break;
		case "AC":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByCultivoEspecieAsc());
			break;
		case "DC":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByCultivoEspecieDesc());
			break;
		case "AP":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByProductoNombreAsc());
			break;
		case "DP":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByProductoNombreDesc());
			break;
		case "ANL":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByNumeroLoteAsc());
			break;
		case "DNL":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByNumeroLoteDesc());
			break;
		case "AFT":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByFechaTratamientoAsc());
			break;
		case "DFT":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByFechaTratamientoDesc());
			break;
		case "APRec":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByFinPlazoRecoleccionAsc());
			break;
		case "DPRec":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByFinPlazoRecoleccionDesc());
			break;
		case "APRee":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByFinPlazoReentradaAsc());
			break;
		case "DPRee":
			model.addAttribute("tratamientos",repTratamientos.findAllByOrderByFinPlazoReentradaDesc());
			break;
		}
		return "/tratamientos/mostrarTratamientos";
	}
	//MODIFICAR TRATAMIENTO
	
	@RequestMapping("/modificarTratamiento")
	public String modificarTratamiento(
			@RequestParam long id,
			Model model) {
		model.addAttribute("cultivos",repCultivos.findAll());
		model.addAttribute("productos",repProductos.findAll());			
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
	public String insertaTratamientos(
			Model model) {
		
		model.addAttribute("cultivos",repCultivos.findAll());
		model.addAttribute("productos",repProductos.findAll());
		return "/tratamientos/insertarTratamiento";
	}
	
	@RequestMapping("/nuevoTratamiento")
	public String nuevoTratamiento(
			@RequestParam(value="enviar", required = false) String enviar,
			@RequestParam(value="cultivo", required = false) Long cultivo,
			@RequestParam(value="producto", required = false) Long producto,
			Tratamiento tratamiento,
			Model model) {
		
		if(enviar != null) {
			repTratamientos.save(tratamiento);
			Cultivo c = repCultivos.getOne(cultivo);
			ProductoFitosanitario p = repProductos.getOne(producto);
			tratamiento.setCultivo(c);
			tratamiento.setProducto(p);
			c.addTratamientos(tratamiento);
		}
		model.addAttribute("path","tratamientos");
		model.addAttribute("mensaje","Se ha insertado el tratamiento con éxito");
		
		return "InsertadoConExito.html";
	}
	
}
