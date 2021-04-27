package practica1.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.model.ProductoFitosanitario;
import practica1.model.Tratamiento;
import practica1.repository.ProductoFitosanitarioRepository;
import practica1.repository.TratamientoRepository;

@Controller
public class ProductosController {
    @Autowired
    private ProductoFitosanitarioRepository repProductoFitosanitario;
	
	@PostConstruct
	public void init() {
        repProductoFitosanitario.save(new ProductoFitosanitario("Hierro", 4, 10));
        repProductoFitosanitario.save(new ProductoFitosanitario("Azufre", 3, 5));
        repProductoFitosanitario.save(new ProductoFitosanitario("Fosfato de Hierro", 7, 3));
        repProductoFitosanitario.save(new ProductoFitosanitario("Nitrato de Amonio", 4));
        repProductoFitosanitario.save(new ProductoFitosanitario("Sulfato de Cobre"));
    }

    @RequestMapping("/productosFitosanitarios")
    public String productosFitosanitarios(
        @RequestParam(required = false) Long producto,
        @RequestParam(required = false) String descripcion,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Long plazoReentrada,
        @RequestParam(required = false) Long plazoRecoleccion,
        Model model){
            if (producto != null && producto > 0){
                System.out.println(producto);
                model.addAttribute("productos", repProductoFitosanitario.getOne(producto));
            }
            else if (nombre != null && nombre != ""){
                model.addAttribute("productos", repProductoFitosanitario.findByNombre(nombre));
            }
            else if (plazoReentrada != null && plazoReentrada > 0){
                model.addAttribute("productos", repProductoFitosanitario.findByPlazoReentrada(plazoReentrada));
            }
            else if (plazoRecoleccion != null && plazoRecoleccion > 0){
                model.addAttribute("productos", repProductoFitosanitario.findByPlazoRecoleccion(plazoRecoleccion));
            }
            else{
                model.addAttribute("productos", repProductoFitosanitario.findAll());
            } 
            return "/productosFitosanitarios/mostrarProductos";
    }

    @RequestMapping("/modificarProducto")
    public String modificarProducto(
        @RequestParam(value = "id") Long id,
        Model model){
            model.addAttribute("producto", repProductoFitosanitario.getOne(id));

            return "/productosFitosanitarios/modificarProducto";
        }
    
    @RequestMapping("/productoModificado")
	public String tratamientoModificado(
			@RequestParam(value="enviar", required = false) String enviar,
			@RequestParam long id,
			ProductoFitosanitario producto,
			Model model) {
		
		if(enviar != null) {
			ProductoFitosanitario prod= repProductoFitosanitario.getOne(id);
			prod.updateProducto(producto);
			repProductoFitosanitario.save(prod);
		}
		model.addAttribute("path","productosFitosanitarios");
		model.addAttribute("mensaje","Se ha modificado el producto con éxito");
		
		return "ModificadoConExito";
	}

    @RequestMapping("/insertarProducto")
    public String insertarProducto(
        Model model){
           return "/productosFitosanitarios/insertarProducto";
        }

    @RequestMapping("/nuevoProducto")
    public String nuevoProducto(
    	@RequestParam(value="enviar", required = false) String enviar,
        ProductoFitosanitario producto,
        Model model){
            
        		
		if(enviar != null) {
			repProductoFitosanitario.save(producto);
		}
		model.addAttribute("path","productosFitosanitarios");
		model.addAttribute("mensaje","Se ha insertado el producto con éxito");
		
		return "InsertadoConExito.html";
    }
    
}


    
    
