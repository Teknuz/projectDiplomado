package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.edu.ucsa.aso.web.api.core.entities.EstadoSocio;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface EstadoSocioRepository extends JpaRepository<EstadoSocio, Long> , JpaSpecificationExecutor<EstadoSocio> {

    List<EstadoSocio> findBySocioIdOrderByFechaEstadoDesc(Integer socioId);

    Optional<EstadoSocio> findFirstBySocioIdOrderByFechaEstadoDesc(Integer socioId);

    List<EstadoSocio> findByEstadoIdOrderByFechaEstadoDesc(Integer estadoId);

    List<EstadoSocio> findByUsuarioCreacionIdOrderByFechaCreacionDesc(Integer usuarioCreacionId);

    List<EstadoSocio> findByFechaEstadoBetweenOrderByFechaEstadoDesc(Timestamp desde, Timestamp hasta);

}
