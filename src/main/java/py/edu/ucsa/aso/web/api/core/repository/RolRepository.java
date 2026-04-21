package py.edu.ucsa.aso.web.api.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import py.edu.ucsa.aso.web.api.core.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long>, JpaSpecificationExecutor<Rol> {
    Optional<Rol> findByNombreRol(String nombreRol);

    boolean existsByNombreRol(String nombreRol);

    List<Rol> findByNombreRolContainingIgnoreCaseOrderByNombreRolAsc(String nombreRol);
}
