package practica1.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface ProductoFitosanitarioRepository extends JpaRepository<Tratamiento, Long> {

}