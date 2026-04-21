package py.edu.ucsa.aso.web.api.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.aso.web.api.core.entities.Dominio;
import py.edu.ucsa.aso.web.api.core.repository.DominioRepository;
import py.edu.ucsa.aso.web.api.core.services.DominioService;

@Service
@Transactional
public class DominioServiceImpl implements DominioService {

	@Autowired
    private DominioRepository dominioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Dominio> findAll() {
        return dominioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Dominio> findById(Integer id) {
        return dominioRepository.findById(id);
    }

    @Override
    public Dominio save(Dominio dominio) {
        return dominioRepository.save(dominio);
    }

    @Override
    public Dominio update(Integer id, Dominio dominio) {
        Dominio actual = dominioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dominio no encontrado con id: " + id));
        BeanUtils.copyProperties(dominio, actual, "id");
        return dominioRepository.save(actual);
    }

    @Override
    public void deleteById(Integer id) {
        if (!dominioRepository.existsById(id)) {
            throw new RuntimeException("Dominio no encontrado con id: " + id);
        }
        dominioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return dominioRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Dominio> findByCodigo(String codigo) {
        return dominioRepository.findByCodigo(codigo);
    }
    @Override
    @Transactional(readOnly = true)
    public boolean existsByCodigo(String codigo) {
        return dominioRepository.existsByCodigo(codigo);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Dominio> findByEstadoOrderByDescripcionAsc(String estado) {
        return dominioRepository.findByEstadoOrderByDescripcionAsc(estado);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Dominio> findByDominioPadreIdOrderByDescripcionAsc(Integer dominioPadreId) {
        return dominioRepository.findByDominioPadreIdOrderByDescripcionAsc(dominioPadreId);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Dominio> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(String descripcion) {
        return dominioRepository.findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(descripcion);
    }

}
