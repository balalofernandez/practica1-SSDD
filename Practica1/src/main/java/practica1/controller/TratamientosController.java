package practica1.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practica1.model.Tratamiento;
import practica1.repository.TratamientoRepository;


public class TratamientosController {
	@Autowired
	private TratamientoRepository repTratamientos;
	
	@PostConstruct
	public void init() {
		repTratamientos.save(new Tratamiento("Mangos", "Hierro", "9999", LocalDate.of(2021,7,5), LocalDate.of(2021,7,5), LocalDate.of(2021,7,9)));
	}
	@RequestMapping("/")
	public String tablon(Model model) {
		
		model.addAttribute("tratamientos", repTratamientos.findAll());
		
		return "mostrarTratamientos";
	}
	
}
