package practica1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ProductoFitosanitario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;
	
	private String descripcion;
	private String nombre;
	private Long plazoReentrada;
	private Long plazoRecoleccion;

	
	public ProductoFitosanitario() {

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
}
