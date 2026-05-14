package ni.edu.uam.peliculas.dtos;

public record PeliculaResponse(
        Long id,
        String titulo,
        String genero,
        Integer anioEstreno,
        Integer duracionMinutos,
        String sinopsis,
        AutorResumenResponse autor
) {
}
