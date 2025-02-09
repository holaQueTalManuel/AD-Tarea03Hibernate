package org.example.Interfaces;

import org.example.Entities.Producto;
import org.example.dto.ProductoDTO;

import java.util.List;

public interface ProductoDAO {
    List<ProductoDTO> getAllProductos();
    void saveProducto(Producto p);
    void deleteProducto(int id);
    void updateProducto(int id, String nombre);

}
