package ni.edu.uam.peliculas.mappers;

import ni.edu.uam.peliculas.dtos.PeliculaRequest;
import ni.edu.uam.peliculas.dtos.PeliculaResponse;
import ni.edu.uam.peliculas.models.Autor;
import ni.edu.uam.peliculas.models.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class PeliculaMapper {

    private final AutorMapper autorMapper;

    public PeliculaMapper(AutorMapper autorMapper) {
        this.autorMapper = autorMapper;
    }

    public Pelicula toEntity(PeliculaRequest request, Autor autor) {
        Pelicula pelicula = new Pelicula();
        updateEntity(pelicula, request, autor);
        return pelicula;
    }

    public void updateEntity(Pelicula pelicula, PeliculaRequest request, Autor autor) {
        pelicula.setTitulo(request.titulo());
        pelicula.setGenero(request.genero());
        pelicula.setAnioEstreno(request.anioEstreno());
        pelicula.setDuracionMinutos(request.duracionMinutos());
        pelicula.setSinopsis(request.sinopsis());
        pelicula.setAutor(autor);
    }

    public PeliculaResponse toResponse(Pelicula pelicula) {
        return new PeliculaResponse(
                pelicula.getId(),
                pelicula.getTitulo(),
                pelicula.getGenero(),
                pelicula.getAnioEstreno(),
                pelicula.getDuracionMinutos(),
                pelicula.getSinopsis(),
                autorMapper.toResumenResponse(pelicula.getAutor())
        );
    }
}
