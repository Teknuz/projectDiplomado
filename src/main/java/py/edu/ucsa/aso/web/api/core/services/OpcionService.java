package py.edu.ucsa.aso.web.api.core.services;

import java.util.List;
import java.util.Optional;
import py.edu.ucsa.aso.web.api.core.entities.Opcion;

public interface OpcionService {

    List<Opcion> findAll();

    Optional<Opcion> findById(Integer id);

    Opcion save(Opcion opcion);

    Opcion update(Integer id, Opcion opcion);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    Optional<Opcion> findByCodigoAndDominioCodigo(String codigo, String dominioCodigo);
    List<Opcion> findByDominioIdAndEstadoOrderByDescripcionAsc(Integer dominioId, String estado);
    List<Opcion> findByDominio_CodigoAndEstadoOrderByDescripcionAsc(String codigoDominio, String estado);
    List<Opcion> findByOpcionPadreIdOrderByDescripcionAsc(Integer opcionPadreId);
    List<Opcion> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(String descripcion);
}
