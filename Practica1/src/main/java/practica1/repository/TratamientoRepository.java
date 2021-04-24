package practica1.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
	Tratamiento findById(long Id);
	List<Tratamiento> findByCultivo(String cultivo);
	List<Tratamiento> findByProducto(String producto);
	List<Tratamiento> findByNumeroLote(String numeroLote);
	List<Tratamiento> findByFechaTratamiento(LocalDate fechaTratamiento);
	List<Tratamiento> findByPlazoReentrada(LocalDate PlazoReentrada);
	List<Tratamiento> findByPlazoRecoleccion(LocalDate PlazoRecoleccion);
}