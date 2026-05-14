package ni.edu.uam.peliculas.dtos;

public record PeliculaRequest(
        String titulo,
        String genero,
        Integer anioEstreno,
        Integer duracionMinutos,
        String sinopsis,
        Long autorId
) {
}
