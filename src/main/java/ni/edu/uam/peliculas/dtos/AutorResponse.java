package ni.edu.uam.peliculas.dtos;

import java.time.LocalDate;

public record AutorResponse(
        Long id,
        String nombre,
        String nacionalidad,
        LocalDate fechaNacimiento
) {
}
