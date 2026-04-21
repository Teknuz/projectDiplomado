package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import py.edu.ucsa.aso.web.api.core.entities.TipoMovimiento;

import java.util.List;
import java.util.Optional;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimiento,Long>, JpaSpecificationExecutor<TipoMovimiento> {

    Optional<TipoMovimiento> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

    List<TipoMovimiento> findByEstadoOrderByDescripcionAsc(String estado);

    List<TipoMovimiento> findByTipoDebCredOrderByDescripcionAsc(String tipoDebCred);

    List<TipoMovimiento> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(String descripcion);

}
