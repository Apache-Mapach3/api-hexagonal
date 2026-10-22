package com.unicartagena.apihexagonal.application.services;

import com.unicartagena.apihexagonal.application.ports.ProductoService;
import com.unicartagena.apihexagonal.domain.model.Producto;
import com.unicartagena.apihexagonal.domain.ports.ProductoRepository;
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
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}