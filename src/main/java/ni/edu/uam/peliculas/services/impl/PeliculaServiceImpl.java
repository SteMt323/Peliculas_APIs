package ni.edu.uam.peliculas.services.impl;

import java.util.List;
import ni.edu.uam.peliculas.dtos.PeliculaRequest;
import ni.edu.uam.peliculas.dtos.PeliculaResponse;
import ni.edu.uam.peliculas.exceptions.RecursoNoEncontradoException;
import ni.edu.uam.peliculas.exceptions.SolicitudInvalidaException;
import ni.edu.uam.peliculas.mappers.PeliculaMapper;
import ni.edu.uam.peliculas.models.Autor;
import ni.edu.uam.peliculas.models.Pelicula;
import ni.edu.uam.peliculas.repositories.AutorRepository;
import ni.edu.uam.peliculas.repositories.PeliculaRepository;
import ni.edu.uam.peliculas.services.PeliculaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final AutorRepository autorRepository;
    private final PeliculaMapper peliculaMapper;

    public PeliculaServiceImpl(
            PeliculaRepository peliculaRepository,
            AutorRepository autorRepository,
            PeliculaMapper peliculaMapper
    ) {
        this.peliculaRepository = peliculaRepository;
        this.autorRepository = autorRepository;
        this.peliculaMapper = peliculaMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeliculaResponse> listar() {
        return peliculaRepository.findAll()
                .stream()
                .map(peliculaMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeliculaResponse> listarPorAutor(Long autorId) {
        validarAutorExiste(autorId);
        return peliculaRepository.findByAutorId(autorId)
                .stream()
                .map(peliculaMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PeliculaResponse buscarPorId(Long id) {
        return peliculaMapper.toResponse(obtenerEntidadPorId(id));
    }

    @Override
    @Transactional
    public PeliculaResponse crear(PeliculaRequest request) {
        validarSolicitud(request);
        Autor autor = obtenerAutorPorId(request.autorId());
        Pelicula pelicula = peliculaMapper.toEntity(request, autor);
        return peliculaMapper.toResponse(peliculaRepository.save(pelicula));
    }

    @Override
    @Transactional
    public PeliculaResponse actualizar(Long id, PeliculaRequest request) {
        validarSolicitud(request);
        Pelicula pelicula = obtenerEntidadPorId(id);
        Autor autor = obtenerAutorPorId(request.autorId());
        peliculaMapper.updateEntity(pelicula, request, autor);
        return peliculaMapper.toResponse(peliculaRepository.save(pelicula));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Pelicula pelicula = obtenerEntidadPorId(id);
        peliculaRepository.delete(pelicula);
    }

    private Pelicula obtenerEntidadPorId(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro la pelicula con id " + id));
    }

    private Autor obtenerAutorPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el autor con id " + id));
    }

    private void validarAutorExiste(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se encontro el autor con id " + id);
        }
    }

    private void validarSolicitud(PeliculaRequest request) {
        if (request == null) {
            throw new SolicitudInvalidaException("La informacion de la pelicula es obligatoria.");
        }

        if (request.titulo() == null || request.titulo().isBlank()) {
            throw new SolicitudInvalidaException("El titulo de la pelicula es obligatorio.");
        }

        if (request.autorId() == null) {
            throw new SolicitudInvalidaException("El id del autor es obligatorio.");
        }
    }
}
