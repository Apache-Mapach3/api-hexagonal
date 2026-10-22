package com.unicartagena.apihexagonal.application.ports;

import com.unicartagena.apihexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de entrada - Define los casos de uso disponibles.
 */
public interface ProductoService {
    Producto crear(Producto producto);
    Optional<Producto> buscarPorId(Long id);
    List<Producto> listarTodos();
    void eliminar(Long id);
}