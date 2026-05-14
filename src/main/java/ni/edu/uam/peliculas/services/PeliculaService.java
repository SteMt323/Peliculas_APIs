package ni.edu.uam.peliculas.services;

import java.util.List;
import ni.edu.uam.peliculas.dtos.PeliculaRequest;
import ni.edu.uam.peliculas.dtos.PeliculaResponse;

public interface PeliculaService {

    List<PeliculaResponse> listar();

    List<PeliculaResponse> listarPorAutor(Long autorId);

    PeliculaResponse buscarPorId(Long id);

    PeliculaResponse crear(PeliculaRequest request);

    PeliculaResponse actualizar(Long id, PeliculaRequest request);

    void eliminar(Long id);
}
