package practica1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Tratamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTratamiento;
	
	private String cultivo;
	private String producto;
	private String numeroLote;
	private LocalDate fechaTratamiento;
	private LocalDate plazoReentrada;
	private LocalDate plazoRecoleccion;

	
	public Tratamiento() {

	}
	public Tratamiento(String cultivo, 
			String producto, 
			String numeroLote, 
			LocalDate fechaTratamiento,
			LocalDate plazoReentrada,
			LocalDate plazoRecoleccion) {
		this.cultivo = cultivo;
		this.producto = producto;
		this.numeroLote = numeroLote;
		this.fechaTratamiento = fechaTratamiento;
		this.plazoReentrada = plazoReentrada;
		this.plazoRecoleccion = plazoRecoleccion;
	}

	public long getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(long idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public long getId() {
		return idTratamiento;
	}

	public void setId(long id) {
		this.idTratamiento = id;
	}

	public String getCultivo() {
		return cultivo;
	}

	public void setCultivo(String cultivo) {
		this.cultivo = cultivo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public LocalDate getFechaTratamiento() {
		return fechaTratamiento;
	}

	public void setFechaTratamiento(LocalDate fechaTratamiento) {
		this.fechaTratamiento = fechaTratamiento;
	}

	public LocalDate getPlazoReentrada() {
		return plazoReentrada;
	}

	public void setPlazoReentrada(LocalDate plazoReentrada) {
		this.plazoReentrada = plazoReentrada;
	}

	public LocalDate getPlazoRecoleccion() {
		return plazoRecoleccion;
	}

	public void setPlazoRecoleccion(LocalDate plazoRecoleccion) {
		this.plazoRecoleccion = plazoRecoleccion;
	}
}
