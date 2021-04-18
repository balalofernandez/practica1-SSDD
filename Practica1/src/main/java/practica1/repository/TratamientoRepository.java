package practica1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.*;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

}