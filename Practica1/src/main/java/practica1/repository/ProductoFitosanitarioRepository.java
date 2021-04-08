package practica1.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface ProductoFitosanitarioRepository extends JpaRepository<Tratamiento, Long> {

	Cultivo findByUsuario(String usuario);
	
	//Obtiene la lista de personas ordenada por orden ascendente del atributo usuario
	ArrayList<Cultivo> findAllByOrderByUsuarioAsc();
}