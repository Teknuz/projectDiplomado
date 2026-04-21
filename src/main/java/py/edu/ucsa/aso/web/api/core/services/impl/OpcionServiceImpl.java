package py.edu.ucsa.aso.web.api.core.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.edu.ucsa.aso.web.api.core.entities.Opcion;
import py.edu.ucsa.aso.web.api.core.repository.OpcionRepository;
import py.edu.ucsa.aso.web.api.core.services.OpcionService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OpcionServiceImpl implements OpcionService {

    @Autowired
    private OpcionRepository opcionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Opcion> findAll() {return opcionRepository.findAll();}

    @Override
    @Transactional(readOnly = true)
    public Optional<Opcion> findById(Integer id) {return opcionRepository.findById(id);}

    @Override
    public Opcion save(Opcion opcion) {return opcionRepository.save(opcion);}

    @Override
    public Opcion update(Integer id, Opcion opcion) {
        Opcion opcionAux = opcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Opcion no encontrado con id: " + id));
        BeanUtils.copyProperties(opcion, opcionAux,"id");
        return opcionRepository.save(opcionAux);
    }

    @Override
    public void deleteById(Integer id) {
        if(!opcionRepository.existsById(id)){
            throw new RuntimeException("Opcion no encontrado con id: " + id);
        }
        opcionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {return opcionRepository.existsById(id);}

    @Override
    public Optional<Opcion> findByCodigoAndDominioCodigo(String codigo, String dominioCodigo) {
        return Optional.empty();
    }

    @Override
    public List<Opcion> findByDominioIdAndEstadoOrderByDescripcionAsc(Integer dominioId, String estado) {
        return List.of();
    }

    @Override
    public List<Opcion> findByDominio_CodigoAndEstadoOrderByDescripcionAsc(String codigoDominio, String estado) {
        return List.of();
    }

    @Override
    public List<Opcion> findByOpcionPadreIdOrderByDescripcionAsc(Integer opcionPadreId) {
        return List.of();
    }

    @Override
    public List<Opcion> findByDescripcionContainingIgnoreCaseOrderByDescripcionAsc(String descripcion) {
        return List.of();
    }

    @Transactional(readOnly = true)
    public Optional<Opcion> findByCodigo(String codigo,Integer id) {return opcionRepository.findByCodigoAndDominioId(codigo,id);}



}
