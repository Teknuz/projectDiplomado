package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.edu.ucsa.aso.web.api.core.entities.MensajeEnviadoSocio;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface MensajeEnviadoSocioRepository extends JpaRepository<MensajeEnviadoSocio, Long> , JpaSpecificationExecutor<MensajeEnviadoSocio> {



    List<MensajeEnviadoSocio> findBySocioDestinoIdOrderByFechaCreacionDesc(Integer socioDestinoId);

    List<MensajeEnviadoSocio> findByMensajeIdOrderByFechaCreacionDesc(Integer mensajeId);

    List<MensajeEnviadoSocio> findByUsuarioCreacionIdOrderByFechaCreacionDesc(Integer usuarioCreacionId);

    List<MensajeEnviadoSocio> findBySocioDestinoIdAndMensajeIdOrderByFechaCreacionDesc(Integer socioDestinoId, Integer mensajeId);

}
