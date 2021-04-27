package practica1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class ProductoFitosanitario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;
	
	private String descripcion;
	@NotNull
	private String nombre;
	private long plazoReentrada;
	private long plazoRecoleccion;

	
	public ProductoFitosanitario() {

	}

	public ProductoFitosanitario(String nombre, long plazoReentrada, long plazoRecoleccion){
		this.nombre = nombre;
		this.plazoReentrada = plazoReentrada;
		this.plazoRecoleccion = plazoRecoleccion;
	}

	public ProductoFitosanitario(String nombre, long plazoRecoleccion){
		this.nombre = nombre;
		this.plazoReentrada = 0;
		this.plazoRecoleccion = plazoRecoleccion;
	}

	public ProductoFitosanitario(String nombre){
		this.nombre = nombre;
		this.plazoReentrada = 0;
		this.plazoRecoleccion = 0;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public long getId() {
		return idProducto;
	}

	public void setId(long id) {
		this.idProducto = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPlazoReentrada() {
		return plazoReentrada;
	}

	public void setPlazoReentrada(Long plazoReentrada) {
		this.plazoReentrada = plazoReentrada;
	}
	public Long getPlazoRecoleccion() {
		return plazoRecoleccion;
	}

	public void setPlazoRecoleccion(Long plazoRecoleccion) {
		this.plazoRecoleccion = plazoRecoleccion;
	}
	public void updateProducto(ProductoFitosanitario prod) {
		this.descripcion = prod.getDescripcion();
		this.nombre = prod.getNombre();
		this.plazoReentrada = prod.getPlazoReentrada();
		this.plazoRecoleccion = prod.getPlazoRecoleccion();
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
