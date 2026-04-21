package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.edu.ucsa.aso.web.api.core.entities.MontoCuota;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface MontoCuotaRepository extends JpaRepository<MontoCuota, Integer>, JpaSpecificationExecutor<MontoCuota> {
    List<MontoCuota> findByEstadoOrderByFechaInicioVigenciaDesc(String estado);

    Optional<MontoCuota> findFirstByEstadoOrderByFechaInicioVigenciaDesc(String estado);

    List<MontoCuota> findByFechaInicioVigenciaLessThanEqualAndFechaFinVigenciaGreaterThanEqual(Timestamp fechaInicio, Timestamp fechaFin);

    List<MontoCuota> findByUsuarioInactivacionIdOrderByFechaInactivacionDesc(Integer usuarioInactivacionId);

    List<MontoCuota> findByMontoGreaterThanEqualOrderByMontoAsc(Double monto);
}
