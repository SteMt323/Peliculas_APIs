package ni.edu.uam.peliculas.services.impl;

import java.util.List;
import ni.edu.uam.peliculas.dtos.AutorRequest;
import ni.edu.uam.peliculas.dtos.AutorResponse;
import ni.edu.uam.peliculas.exceptions.RecursoNoEncontradoException;
import ni.edu.uam.peliculas.exceptions.SolicitudInvalidaException;
import ni.edu.uam.peliculas.mappers.AutorMapper;
import ni.edu.uam.peliculas.models.Autor;
import ni.edu.uam.peliculas.repositories.AutorRepository;
import ni.edu.uam.peliculas.services.AutorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    public AutorServiceImpl(AutorRepository autorRepository, AutorMapper autorMapper) {
        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutorResponse> listar() {
        return autorRepository.findAll()
                .stream()
                .map(autorMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AutorResponse buscarPorId(Long id) {
        return autorMapper.toResponse(obtenerEntidadPorId(id));
    }

    @Override
    @Transactional
    public AutorResponse crear(AutorRequest request) {
        validarSolicitud(request);
        Autor autor = autorMapper.toEntity(request);
        return autorMapper.toResponse(autorRepository.save(autor));
    }

    @Override
    @Transactional
    public AutorResponse actualizar(Long id, AutorRequest request) {
        validarSolicitud(request);
        Autor autor = obtenerEntidadPorId(id);
        autorMapper.updateEntity(autor, request);
        return autorMapper.toResponse(autorRepository.save(autor));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Autor autor = obtenerEntidadPorId(id);
        autorRepository.delete(autor);
    }

    private Autor obtenerEntidadPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el autor con id " + id));
    }

    private void validarSolicitud(AutorRequest request) {
        if (request == null) {
            throw new SolicitudInvalidaException("La informacion del autor es obligatoria.");
        }

        if (request.nombre() == null || request.nombre().isBlank()) {
            throw new SolicitudInvalidaException("El nombre del autor es obligatorio.");
        }
    }
}
