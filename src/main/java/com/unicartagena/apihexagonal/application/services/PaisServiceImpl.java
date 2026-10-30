package com.unicartagena.apihexagonal.application.services;

import com.unicartagena.apihexagonal.application.ports.PaisService;
import com.unicartagena.apihexagonal.domain.model.Pais;
import com.unicartagena.apihexagonal.domain.ports.PaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del caso de uso.
 * Coordina la lógica de negocio usando los puertos.
 */
@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    @Override
    public Pais crear(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public Optional<Pais> buscarPorId(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    public List<Pais> listarTodos() {
        return paisRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        paisRepository.deleteById(id);
    }
}