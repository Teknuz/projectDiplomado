package py.edu.ucsa.aso.web.api.core.services;

import java.util.List;
import java.util.Optional;

import py.edu.ucsa.aso.web.api.core.entities.Dominio;

public interface DominioService {

    List<Dominio> findAll();

    Optional<Dominio> findById(Integer id);

    Dominio save(Dominio dominio);

    Dominio update(Integer id, Dominio dominio);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    Optional<Dominio> findByCodigo(String codigo);
    boolean existsByCodigo(String codigo);
    List<Dominio> findByEstadoOrderByDescripcionAsc(String estado);
    List<Dominio> findByDominioPadreIdOrderByDescripcionAsc(Integer dominioPadreId);
    List<Dominio> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(String descripcion);
}
