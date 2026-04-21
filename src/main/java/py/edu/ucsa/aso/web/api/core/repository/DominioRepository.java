package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.edu.ucsa.aso.web.api.core.entities.Dominio;

import java.util.List;
import java.util.Optional;

public interface DominioRepository extends JpaRepository <Dominio, Integer> , JpaSpecificationExecutor<Dominio> {

    Optional<Dominio> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

    List<Dominio> findByEstadoOrderByDescripcionAsc(String estado);

    List<Dominio> findByDominioPadreIdOrderByDescripcionAsc(Integer dominioPadreId);

    List<Dominio> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(String descripcion);

}
