package ni.edu.uam.peliculas.dtos;

import java.time.LocalDate;

public record AutorRequest(
        String nombre,
        String nacionalidad,
        LocalDate fechaNacimiento
) {
}
