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
	boolean existsById(Long id);
	List<Tratamiento> findAllByOrderByIdTratamientoAsc();
	List<Tratamiento> findAllByOrderByIdTratamientoDesc();
	List<Tratamiento> findAllByOrderByCultivoEspecieAsc();
	List<Tratamiento> findAllByOrderByCultivoEspecieDesc();
	List<Tratamiento> findAllByOrderByProductoNombreAsc();
	List<Tratamiento> findAllByOrderByProductoNombreDesc();
	List<Tratamiento> findAllByOrderByNumeroLoteAsc();
	List<Tratamiento> findAllByOrderByNumeroLoteDesc();
	List<Tratamiento> findAllByOrderByFechaTratamientoAsc();
	List<Tratamiento> findAllByOrderByFechaTratamientoDesc();
	List<Tratamiento> findAllByOrderByFinPlazoRecoleccionAsc();
	List<Tratamiento> findAllByOrderByFinPlazoRecoleccionDesc();
	List<Tratamiento> findAllByOrderByFinPlazoReentradaAsc();
	List<Tratamiento> findAllByOrderByFinPlazoReentradaDesc();
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBefore(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByIdTratamientoAsc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByIdTratamientoDesc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByCultivoEspecieAsc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByCultivoEspecieDesc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByProductoNombreAsc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByProductoNombreDesc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByNumeroLoteAsc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByNumeroLoteDesc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByFechaTratamientoAsc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByFechaTratamientoDesc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByFinPlazoRecoleccionAsc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByFinPlazoRecoleccionDesc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByFinPlazoReentradaAsc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	List<Tratamiento> findByFinPlazoRecoleccionAfterAndFechaTratamientoBeforeOrFinPlazoReentradaAfterAndFechaTratamientoBeforeOrderByFinPlazoReentradaDesc(
			LocalDate f1, LocalDate f2, LocalDate f3, LocalDate f4);
	
	
}
