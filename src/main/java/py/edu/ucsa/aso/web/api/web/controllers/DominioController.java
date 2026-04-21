package py.edu.ucsa.aso.web.api.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.edu.ucsa.aso.web.api.core.entities.Dominio;
import py.edu.ucsa.aso.web.api.core.services.DominioService;

@RestController
@RequestMapping("/api/dominios")
public class DominioController {

    private final DominioService dominioService;

    public DominioController(DominioService dominioService) {
        this.dominioService = dominioService;
    }

    @GetMapping
    public ResponseEntity<List<Dominio>> findAll() {
        return ResponseEntity.ok(dominioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dominio> findById(@PathVariable Integer id) {
        return dominioService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dominio> create(@RequestBody Dominio dominio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dominioService.save(dominio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dominio> update(@PathVariable Integer id, @RequestBody Dominio dominio) {
        return ResponseEntity.ok(dominioService.update(id, dominio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        dominioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/findByCodigo")
    public ResponseEntity<Dominio> findByCodigo(@RequestParam String codigo) {
        return dominioService.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/search/existsByCodigo")
    public ResponseEntity<Boolean> existsByCodigo(@RequestParam String codigo) {
        return ResponseEntity.ok(dominioService.existsByCodigo(codigo));
    }
    @GetMapping("/search/findByEstadoOrderByDescripcionAsc")
    public ResponseEntity<List<Dominio>> findByEstadoOrderByDescripcionAsc(@RequestParam String estado) {
        return ResponseEntity.ok(dominioService.findByEstadoOrderByDescripcionAsc(estado));
    }
    @GetMapping("/search/findByDominioPadreIdOrderByDescripcionAsc")
    public ResponseEntity<List<Dominio>> findByDominioPadreIdOrderByDescripcionAsc(@RequestParam Integer dominioPadreId) {
        return ResponseEntity.ok(dominioService.findByDominioPadreIdOrderByDescripcionAsc(dominioPadreId));
    }
    @GetMapping("/search/findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc")
    public ResponseEntity<List<Dominio>> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(@RequestParam String descripcion) {
        return ResponseEntity.ok(dominioService.findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(descripcion));
    }

}
