package practica1.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface ProductoFitosanitarioRepository extends JpaRepository<ProductoFitosanitario, Long> {
    ProductoFitosanitario findById(long Id);
	List<ProductoFitosanitario> findByCultivo(String cultivo);
	List<ProductoFitosanitario> findByProducto(String producto);
	List<Productofitosanitario> findByNumeroLote(String numeroLote);
	List<ProductoFitosanitario> findByFechaTratamiento(LocalDate fechaTratamiento);
	List<ProductoFitosanitario> findByPlazoReentrada(LocalDate PlazoReentrada);
	List<ProductoFitosanitario> findByPlazoRecoleccion(LocalDate PlazoRecoleccion);
}
}