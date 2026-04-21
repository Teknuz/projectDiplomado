package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.edu.ucsa.aso.web.api.core.entities.Socio;

import java.util.List;
import java.util.Optional;

public interface SocioRepository extends JpaRepository<Socio, Long>, JpaSpecificationExecutor<Socio> {
    Optional<Socio> findByNroCedula(Long nroCedula);

    Optional<Socio> findByNroSocio(Integer nroSocio);

    boolean existsByNroCedula(Long nroCedula);

    boolean existsByNroSocio(Integer nroSocio);

    List<Socio> findByEstadoActualIdOrderByApellidosAscNombresAsc(Integer estadoActualId);

    List<Socio> findByTipoSocioIdOrderByApellidosAscNombresAsc(Integer tipoSocioId);

    List<Socio> findByApellidosContainingIgnoreCaseOrNombresContainingIgnoreCaseOrderByApellidosAscNombresAsc(String apellidos, String nombres);
}
