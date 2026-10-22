package com.unicartagena.apihexagonal.domain.ports;

import com.unicartagena.apihexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida - Define el contrato de persistencia.
 * El dominio NO conoce cómo se implementa.
 */
public interface ProductoRepository {
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
    List<Producto> findAll();
    void deleteById(Long id);
}