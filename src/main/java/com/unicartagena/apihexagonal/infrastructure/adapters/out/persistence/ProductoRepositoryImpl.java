package com.unicartagena.apihexagonal.infrastructure.adapters.out.persistence;

import com.unicartagena.apihexagonal.domain.model.Producto;
import com.unicartagena.apihexagonal.domain.ports.ProductoRepository;
import com.unicartagena.apihexagonal.infrastructure.adapters.out.persistence.entity.ProductoEntity;
import com.unicartagena.apihexagonal.infrastructure.adapters.out.persistence.repository.JpaProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador de salida - Implementa el puerto del dominio usando JPA.
 */
@Component
@RequiredArgsConstructor
public class ProductoRepositoryImpl implements ProductoRepository {

    private final JpaProductoRepository jpaRepository;

    @Override
    public Producto save(Producto producto) {
        ProductoEntity entity = toEntity(producto);
        return toModel(jpaRepository.save(entity));
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public List<Producto> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // ============ MAPPERS ============
    private Producto toModel(ProductoEntity e) {
        return Producto.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .descripcion(e.getDescripcion())
                .precio(e.getPrecio())
                .stock(e.getStock())
                .build();
    }

    private ProductoEntity toEntity(Producto p) {
        ProductoEntity e = new ProductoEntity();
        e.setId(p.getId());
        e.setNombre(p.getNombre());
        e.setDescripcion(p.getDescripcion());
        e.setPrecio(p.getPrecio());
        e.setStock(p.getStock());
        return e;
    }
}