package ni.edu.uam.peliculas.services;

import java.util.List;
import ni.edu.uam.peliculas.dtos.AutorRequest;
import ni.edu.uam.peliculas.dtos.AutorResponse;

public interface AutorService {

    List<AutorResponse> listar();

    AutorResponse buscarPorId(Long id);

    AutorResponse crear(AutorRequest request);

    AutorResponse actualizar(Long id, AutorRequest request);

    void eliminar(Long id);
}
