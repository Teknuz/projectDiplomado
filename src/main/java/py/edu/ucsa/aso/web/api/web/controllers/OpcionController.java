package py.edu.ucsa.aso.web.api.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.ucsa.aso.web.api.core.entities.Opcion;
import py.edu.ucsa.aso.web.api.core.services.OpcionService;

import java.util.List;

@RestController
@RequestMapping("/api/opciones")
public class OpcionController {
    @Autowired
    private OpcionService opcionService;

    @GetMapping
    public ResponseEntity<List<Opcion>> findAll() {return ResponseEntity.ok(opcionService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Opcion> findById(@PathVariable Integer id) {
        return opcionService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Opcion> create(@RequestBody Opcion opcion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(opcionService.save(opcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opcion> update(@PathVariable Integer id, @RequestBody Opcion opcion) {
        return ResponseEntity.ok(opcionService.save(opcion));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        opcionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/findByCodigoAndDominioCodigo")
    public ResponseEntity<Opcion> findByCodigoAndDominioCodigo(@RequestParam String codigo,@RequestParam String dominioCodigo) {
        return opcionService.findByCodigoAndDominioCodigo(codigo,dominioCodigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/search/findByDominioIdAndEstadoOrderByDescripcionAsc")
    public ResponseEntity <List<Opcion>> findByDominioIdAndEstadoOrderByDescripcionAsc(@RequestParam Integer dominioId,@RequestParam String estado) {
        return ResponseEntity.ok(opcionService.findByDominioIdAndEstadoOrderByDescripcionAsc(dominioId,estado));
    }
    @GetMapping("/search/findByDominio_CodigoAndEstadoOrderByDescripcionAsc")
    public ResponseEntity<List<Opcion>> findByEstadoOrderByDescripcionAsc(@RequestParam String codigoDominio, @RequestParam String estado) {
        return ResponseEntity.ok(opcionService.findByDominio_CodigoAndEstadoOrderByDescripcionAsc(codigoDominio,estado));
    }
    @GetMapping("/search/findByOpcionPadreIdOrderByDescripcionAsc")
    public ResponseEntity<List<Opcion>> findByOpcionPadreIdOrderByDescripcionAsc(@RequestParam Integer OpcionPadreId) {
        return ResponseEntity.ok(opcionService.findByOpcionPadreIdOrderByDescripcionAsc(OpcionPadreId));
    }
    @GetMapping("/search/findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc")
    public ResponseEntity<List<Opcion>> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(@RequestParam String descripcion) {
        return ResponseEntity.ok(opcionService.findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(descripcion));
    }


}
