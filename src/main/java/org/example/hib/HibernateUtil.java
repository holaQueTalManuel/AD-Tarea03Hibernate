package org.example.hib;

import org.example.Entities.Cliente;
import org.example.Entities.Producto;
import org.example.Entities.Venta;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Producto.class)
                    .addAnnotatedClass(Venta.class);


            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al inicializar la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
