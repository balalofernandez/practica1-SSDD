package practica1.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface CultivoRepository extends JpaRepository<Cultivo, Long> {
	Cultivo findById(long Id);
	List<Cultivo> findByEspecie(String especie);
	List<Cultivo> findByVariedad(String variedad);
	List<Cultivo> findByFechaPlantacion(LocalDate fechaPlantacion);
	List<Cultivo> findByZona(String zona);
}
