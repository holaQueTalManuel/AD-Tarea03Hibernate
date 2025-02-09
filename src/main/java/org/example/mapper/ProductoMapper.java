package org.example.mapper;

import org.example.Entities.Producto;
import org.example.dto.ProductoDTO;

public class ProductoMapper {
    public static ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio_compra(),
                producto.getPrecio_venta(),
                producto.getStock()
        );
    }

    public static Producto toEntity(ProductoDTO productoDTO) {
        return new Producto(
                productoDTO.getId(),
                productoDTO.getNombre(),
                productoDTO.getPrecioCompra(),
                productoDTO.getPrecioVenta(),
                productoDTO.getStock()
        );
    }
}
