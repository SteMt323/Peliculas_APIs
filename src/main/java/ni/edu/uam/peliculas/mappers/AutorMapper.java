package ni.edu.uam.peliculas.mappers;

import ni.edu.uam.peliculas.dtos.AutorRequest;
import ni.edu.uam.peliculas.dtos.AutorResponse;
import ni.edu.uam.peliculas.dtos.AutorResumenResponse;
import ni.edu.uam.peliculas.models.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public Autor toEntity(AutorRequest request) {
        Autor autor = new Autor();
        updateEntity(autor, request);
        return autor;
    }

    public void updateEntity(Autor autor, AutorRequest request) {
        autor.setNombre(request.nombre());
        autor.setNacionalidad(request.nacionalidad());
        autor.setFechaNacimiento(request.fechaNacimiento());
    }

    public AutorResponse toResponse(Autor autor) {
        return new AutorResponse(
                autor.getId(),
                autor.getNombre(),
                autor.getNacionalidad(),
                autor.getFechaNacimiento()
        );
    }

    public AutorResumenResponse toResumenResponse(Autor autor) {
        return new AutorResumenResponse(autor.getId(), autor.getNombre());
    }
}
