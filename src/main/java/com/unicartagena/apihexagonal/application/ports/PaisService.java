package com.unicartagena.apihexagonal.application.ports;

import com.unicartagena.apihexagonal.domain.model.Pais;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de entrada - Define los casos de uso disponibles.
 */
public interface PaisService {
    Pais crear(Pais pais);
    Optional<Pais> buscarPorId(Long id);
    List<Pais> listarTodos();
    void eliminar(Long id);
}