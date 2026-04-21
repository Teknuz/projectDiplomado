package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.edu.ucsa.aso.web.api.core.entities.Exposicion;

import java.sql.Timestamp;
import java.util.List;

public interface ExposicionRepository extends JpaRepository<Exposicion, Long> , JpaSpecificationExecutor <Exposicion> {
    List<Exposicion> findAllByOrderByFechaExpoDesc();

    List<Exposicion> findByNombreContainingIgnoreCaseOrderByFechaExpoDesc(String nombre);

    List<Exposicion> findByOrganizaContainingIgnoreCaseOrderByFechaExpoDesc(String organiza);

    List<Exposicion> findByFechaExpoBetweenOrderByFechaExpoAsc(Timestamp desde, Timestamp hasta);

    List<Exposicion> findByUsuarioCreacionIdOrderByFechaCreacionDesc(Integer usuarioCreacionId);

    List<Exposicion> findAllByOrderByFechaExpoAsc();
}
