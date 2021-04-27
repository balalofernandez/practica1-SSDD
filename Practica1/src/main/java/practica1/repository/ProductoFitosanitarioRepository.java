package practica1.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface ProductoFitosanitarioRepository extends JpaRepository<ProductoFitosanitario, Long> {
    ProductoFitosanitario findById(long Id);
	List<Tratamiento> findByNombre(String nombre);
	List<ProductoFitosanitario> findByPlazoReentrada(Long PlazoReentrada);
	List<ProductoFitosanitario> findByPlazoRecoleccion(Long PlazoRecoleccion);
}