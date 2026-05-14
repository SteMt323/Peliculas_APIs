package ni.edu.uam.peliculas.repositories;

import ni.edu.uam.peliculas.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
