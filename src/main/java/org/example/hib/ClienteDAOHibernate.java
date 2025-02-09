package org.example.hib;

import org.example.Entities.Cliente;
import org.example.Entities.Producto;
import org.example.Interfaces.ClienteDAO;
import org.example.dto.ClienteDTO;
import org.example.mapper.ClienteMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDAOHibernate implements ClienteDAO {
    @Override
    public List<ClienteDTO> getAllClientes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Cliente> query = session.createQuery("FROM Cliente ", Cliente.class);
            List<Cliente> clientes = query.list();

            return clientes.stream()
                    .map(ClienteMapper::toDTO)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void saveCliente(Cliente c) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(c);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Cliente cliente = session.get(Cliente.class, id);

            if (cliente != null){
                session.delete(cliente);
                tx.commit();
            }else {
                System.out.println("Cliente no encontrado con el id: " + id);
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();  // Loguea el error para más detalles

        }
    }
}
