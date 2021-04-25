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
	private long idcultivo;
	
	private String especie;	
	private String variedad;
	private String fechaPlantacion;
	private String zona;
	
	//private ArrayList<Tratamiento> tratamientos;
	
	public Cultivo() {

	}

	public long getIdCultivo() {
		return idcultivo;
	}

	
	public void setIdCultivo(long idcultivo) {
		this.idcultivo = idcultivo;
	}

	
	/*public ArrayList<Tratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setAnuncios(ArrayList<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}*/

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

	@Override
	public String toString() {
		return "Cultivo [idcultivo=" + idcultivo + ", variedad=" + variedad + ", fechaPlantacion=" + fechaPlantacion + ", zona="
				+ zona + "]";
	}

}
