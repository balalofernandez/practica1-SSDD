package practica1.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
	Tratamiento findById(long Id);
	List<Tratamiento> findByFinPlazoReentrada(LocalDate PlazoReentrada);
	List<Tratamiento> findByFinPlazoRecoleccion(LocalDate PlazoRecoleccion);
	List<Tratamiento> findByFechaTratamiento(LocalDate PlazoRecoleccion);
	List<Tratamiento> findByCultivoEspecie(String cultivo);
	List<Tratamiento> findByProductoNombre(String producto);
	List<Tratamiento> findByNumeroLote(String producto);
}