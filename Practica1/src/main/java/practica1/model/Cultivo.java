package practica1.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cultivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idCultivo",updatable = false, nullable = false)
	private long idcultivo;
	@Column(name="especie")
	private String especie;	
	@Column(name="variedad")
	private String variedad;
	private LocalDate fechaPlantacion;
	private String zona;
	
	private ArrayList<Tratamiento> tratamientos;
	
	public Cultivo() {

	}
	
	public Cultivo(String especie, 
			String variedad, 
			LocalDate fechaPlantacion, 
			String zona, 
			ArrayList<Tratamiento> tratamientos) {
		this.especie = especie;
		this.variedad = variedad;
		this.fechaPlantacion = fechaPlantacion;
		this.zona = zona;
		this.tratamientos = tratamientos;
	}
	
	public long getIdCultivo() {
		return idcultivo;
	}

	
	public void setIdCultivo(long idcultivo) {
		this.idcultivo = idcultivo;
	}

	
	*public ArrayList<Tratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}*

	public String getEspecie() {
		return especie;
	}

	public void setId(String especie) {
		this.especie = especie;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public String getFechaPlantacion() {
		return fechaPlantacion;
	}

	public void setFechaPlantacion(String fechaPlantacion) {
		this.fechaPlantacion = fechaPlantacion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public void updateCultivo(Cultivo cult) {
		this.especie = cult.especie;
		this.variedad = cult.variedad;
		this.fechaPlantacion = trat.fechaPlantacion;
		this.zona = trat.zona;
	}

	@Override
	public String toString() {
		return "Cultivo [idcultivo=" + idcultivo + ", variedad=" + variedad + ", fechaPlantacion=" + fechaPlantacion + ", zona="
				+ zona + "]";
	}

}
