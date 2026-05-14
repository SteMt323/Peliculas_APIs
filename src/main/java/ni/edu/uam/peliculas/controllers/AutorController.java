package ni.edu.uam.peliculas.controllers;

import java.util.List;
import ni.edu.uam.peliculas.dtos.AutorRequest;
import ni.edu.uam.peliculas.dtos.AutorResponse;
import ni.edu.uam.peliculas.dtos.PeliculaResponse;
import ni.edu.uam.peliculas.services.AutorService;
import ni.edu.uam.peliculas.services.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;
    private final PeliculaService peliculaService;

    public AutorController(AutorService autorService, PeliculaService peliculaService) {
        this.autorService = autorService;
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> listar() {
        return ResponseEntity.ok(autorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @GetMapping("/{id}/peliculas")
    public ResponseEntity<List<PeliculaResponse>> listarPeliculas(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.listarPorAutor(id));
    }

    @PostMapping
    public ResponseEntity<AutorResponse> crear(@RequestBody AutorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponse> actualizar(@PathVariable Long id, @RequestBody AutorRequest request) {
        return ResponseEntity.ok(autorService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        autorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
