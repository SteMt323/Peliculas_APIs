package ni.edu.uam.peliculas.repositories;

import java.util.List;
import ni.edu.uam.peliculas.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByAutorId(Long autorId);
}
