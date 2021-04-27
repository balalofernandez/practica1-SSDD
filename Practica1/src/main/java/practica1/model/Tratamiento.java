package practica1.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Tratamiento implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idTratamiento",updatable = false, nullable = false)
	private long idTratamiento;
	@ManyToOne
	@JoinColumn(name="idCultivo")
	private Cultivo cultivo;
	@OneToOne
	private ProductoFitosanitario producto;
	private String numeroLote;
	private LocalDate fechaTratamiento;
	private LocalDate finPlazoReentrada;
	private LocalDate finPlazoRecoleccion;

	
	public Tratamiento() {

	}
	public Tratamiento(Cultivo cultivo, 
			ProductoFitosanitario producto, 
			String numeroLote) {
		this.cultivo = cultivo;
		this.producto = producto;
		this.numeroLote = numeroLote;
	}
	public Tratamiento(Cultivo cultivo, 
			ProductoFitosanitario producto, 
			String numeroLote, 
			LocalDate fechaTratamiento) {
		this.cultivo = cultivo;
		this.producto = producto;
		this.numeroLote = numeroLote;
		this.fechaTratamiento = fechaTratamiento;
		this.finPlazoReentrada = fechaTratamiento.plusDays(producto.getPlazoReentrada());
		this.finPlazoRecoleccion = fechaTratamiento.plusDays(producto.getPlazoRecoleccion());
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

	public Cultivo getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}

	public ProductoFitosanitario getProducto() {
		return producto;
	}

	public void setProducto(ProductoFitosanitario producto) {
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

	public LocalDate getFinPlazoReentrada() {
		return finPlazoReentrada;
	}

	public void setFinPlazoReentrada(String finPlazoReentrada) {
		this.finPlazoReentrada= LocalDate.parse(finPlazoReentrada);
	}

	public LocalDate getFinPlazoRecoleccion() {
		return finPlazoRecoleccion;
	}

	public void setFinPlazoRecoleccion(String finPlazoRecoleccion) {
		this.finPlazoRecoleccion = LocalDate.parse(finPlazoRecoleccion);
	}
	
	public void updateTratamiento(Tratamiento trat) {
		this.cultivo = trat.cultivo;
		this.producto = trat.producto;
		this.numeroLote = trat.numeroLote;
		this.fechaTratamiento = trat.fechaTratamiento;
		this.finPlazoReentrada = trat.finPlazoReentrada;
		this.finPlazoRecoleccion = trat.finPlazoRecoleccion;
	}
	
}
