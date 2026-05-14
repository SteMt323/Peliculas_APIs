package ni.edu.uam.peliculas.controllers;

import java.util.List;
import ni.edu.uam.peliculas.dtos.PeliculaRequest;
import ni.edu.uam.peliculas.dtos.PeliculaResponse;
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
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaResponse>> listar() {
        return ResponseEntity.ok(peliculaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PeliculaResponse> crear(@RequestBody PeliculaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaResponse> actualizar(@PathVariable Long id, @RequestBody PeliculaRequest request) {
        return ResponseEntity.ok(peliculaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
