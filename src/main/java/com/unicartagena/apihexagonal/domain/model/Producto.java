package com.unicartagena.apihexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad de dominio pura - Producto.
 * No tiene dependencias de Spring ni JPA.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
}