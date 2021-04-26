package practica1.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Tratamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idTratamiento",updatable = false, nullable = false)
	private Long idTratamiento;
	@Column(name="cultivo")
	private String cultivo;
	@Column(name="producto")
	private String producto;
	private String numeroLote;
	private LocalDate fechaTratamiento;
	private LocalDate plazoReentrada;
	private LocalDate plazoRecoleccion;

	
	public Tratamiento() {

	}
	public Tratamiento(String cultivo, 
			String producto, 
			String numeroLote) {
		this.cultivo = cultivo;
		this.producto = producto;
		this.numeroLote = numeroLote;
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

	
	
	public Long getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(long idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public Long getId() {
		return this.idTratamiento;
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

	public void setFechaTratamiento(String fechaTratamiento) {
		this.fechaTratamiento = LocalDate.parse(fechaTratamiento);
	}

	public LocalDate getPlazoReentrada() {
		return plazoReentrada;
	}

	public void setPlazoReentrada(String plazoReentrada) {
		this.plazoReentrada= LocalDate.parse(plazoReentrada);
	}

	public LocalDate getPlazoRecoleccion() {
		return plazoRecoleccion;
	}

	public void setPlazoRecoleccion(String plazoRecoleccion) {
		this.plazoRecoleccion = LocalDate.parse(plazoRecoleccion);
	}
	
	public void updateTratamiento(Tratamiento trat) {
		this.cultivo = trat.cultivo;
		this.producto = trat.producto;
		this.numeroLote = trat.numeroLote;
		this.fechaTratamiento = trat.fechaTratamiento;
		this.plazoReentrada = trat.plazoReentrada;
		this.plazoRecoleccion = trat.plazoRecoleccion;
	}
	
}
