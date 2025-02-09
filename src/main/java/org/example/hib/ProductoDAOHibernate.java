package org.example.hib;

import org.example.Entities.Producto;
import org.example.Interfaces.ProductoDAO;
import org.example.dto.ProductoDTO;
import org.example.mapper.ProductoMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductoDAOHibernate implements ProductoDAO {


    public ProductoDAOHibernate() {
    }

    @Override
    public List<ProductoDTO> getAllProductos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Producto> query = session.createQuery("FROM Producto", Producto.class);
            List<Producto> productos = query.list();

            // Convertimos los productos a DTOs antes de retornarlos
            return productos.stream()
                    .map(ProductoMapper::toDTO)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();  // Maneja el error de manera apropiada
            return Collections.emptyList(); // Retorna lista vacía en lugar de null
        }
    }

    @Override
    public void saveProducto(Producto p) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProducto(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Producto producto = session.get(Producto.class, id);

            if (producto != null){
                session.delete(producto);
                tx.commit();
            }else {
                System.out.println("Producto no encontrado con el id: " + id);
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();  // Loguea el error para más detalles

        }
    }

    @Override
    public void updateProducto(int id, String nombre) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Query query = session.createQuery("UPDATE Producto p SET p.nombre = :nombre WHERE p.id = :id");
            query.setParameter("nombre", nombre);
            query.setParameter("id", id);

            int result = query.executeUpdate();

            if (result > 0) {
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("Producto no encontrado con el id: " + id);
            }


        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();  // Agregar un log detallado

        }
    }
}
