package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import py.edu.ucsa.aso.web.api.core.entities.Dominio;
import py.edu.ucsa.aso.web.api.core.entities.Opcion;

import java.util.List;
import java.util.Optional;
public interface OpcionRepository extends JpaRepository<Opcion, Integer>, JpaSpecificationExecutor<Opcion> {

    Optional<Opcion> findByCodigoAndDominioId(String codigo, Integer dominioId);

    List<Opcion> findByDominioIdAndEstadoOrderByDescripcionAsc(Integer dominioId, String estado);

    List<Opcion> findByDominioCodigoAndEstadoOrderByDescripcionAsc(String codigoDominio, String estado);

    List<Opcion> findByOpcionPadreIdOrderByDescripcionAsc(Integer opcionPadreId);

    List<Opcion> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(String descripcion);
}

