package org.example;

import org.example.Entities.Cliente;
import org.example.Entities.Producto;
import org.example.Entities.Venta;
import org.example.hib.ClienteDAOHibernate;
import org.example.hib.ProductoDAOHibernate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();
    }

    public static void menu(){
        ProductoDAOHibernate productoDAOImpl = new ProductoDAOHibernate();
        ClienteDAOHibernate clienteDAOImpl = new ClienteDAOHibernate();


        Scanner in = new Scanner(System.in);
        int opcionTabla;

        do {
            System.out.println("En que tabla quieres trabajar: 1. Productos, 2. Clientes, 3. Ventas, 4. Ventas_Clientes, 5.Salir (Introduce un numero)");
            opcionTabla = in.nextInt();

            switch (opcionTabla){
                case 1:
                    System.out.println("Dime que quieres hacer: 1. Obtener listado completo, 2. Insertar, 3. Eliminar, 4. Actualizar");
                    int accion = in.nextInt();
                    in.nextLine();
                    switch (accion){
                        case 1:
                            System.out.println("Aqui esta la lista al completo: ");
                            productoDAOImpl.getAllProductos().forEach(System.out::println);
                            break;
                        case 2:
                            System.out.println("Introduce los datos necesarios (solo puedes dejar en blanco stock)");

                            System.out.println("Nombre:");
                            String nombre = in.nextLine();

                            System.out.println("Precio de compra:");
                            float precioC = in.nextFloat();

                            System.out.println("Precio de venta:");
                            float precioV = in.nextFloat();

                            System.out.println("Stock:");
                            int stock = in.nextInt();

                            Producto p = new Producto(nombre, precioC, precioV, stock);
                            productoDAOImpl.saveProducto(p);
                            break;
                        case 3:
                            System.out.println("Introduce el id del producto");
                            System.out.println("ID:");
                            int idEliminar = in.nextInt();
                            in.nextLine();

                            productoDAOImpl.deleteProducto(idEliminar);
                            break;
                        case 4:
                            System.out.println("Introduce el id del producto y el nuevo nombre");
                            System.out.println("ID:");
                            int idProducto = in.nextInt();
                            in.nextLine();

                            System.out.println("Introduce el nuevo nombre");
                            String nuevoNombre = in.nextLine();


                            productoDAOImpl.updateProducto(idProducto, nuevoNombre);
                            break;
                        default:
                            System.out.println("INTRODUCE UNA OPCION VALIDA");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Dime que quieres hacer: 1. Obtener listado completo, 2. Insertar, 3. Eliminar");
                    int accionCliente = in.nextInt();
                    in.nextLine();

                    switch (accionCliente){
                        case 1:
                            System.out.println("Aqui esta la lista al completo: ");
                            clienteDAOImpl.getAllClientes().forEach(System.out::println);
                            break;
                        case 2:
                            System.out.println("Introduce los datos necesarios (direccion, email y telefono puedes dejarlos en blanco)");


                            System.out.println("Nombre:");
                            String nombre = in.nextLine();

                            System.out.println("Email:");
                            String email = in.nextLine();

                            System.out.println("Telefono:");
                            String telefono = in.nextLine();

                            System.out.println("Direccion:");
                            String dir = in.nextLine();

                            Cliente c = new Cliente(nombre, email, telefono, dir);
                            clienteDAOImpl.saveCliente(c);
                            break;
                        case 3:
                            System.out.println("Introduce el id del cliente");
                            System.out.println("ID:");
                            int idEliminar = in.nextInt();
                            in.nextLine();

                            clienteDAOImpl.deleteCliente(idEliminar);
                            break;
                        default:
                            System.out.println("OPCION INCORRECTA");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Dime que quieres hacer: 1. Obtener listado completo, 2. Insertar");
                    int accionVenta = in.nextInt();
                    in.nextLine();

                    switch (accionVenta){
                        case 1:
                            System.out.println("Aqui esta la lista al completo: ");
                            //ventaDAOImpl.getAllVentas().forEach(System.out::println);
                            break;
                        case 2:
                            System.out.println("Introduce los datos necesarios (fecha no es necesario introducirla)");

                            System.out.println("Total:");
                            float total = in.nextFloat();

                            Venta v = new Venta(total);
                            //ventaDAOImpl.saveVenta(v);
                            break;
                        default:
                            System.out.println("OPCION INCORRECTA");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Dime que quieres hacer: 1. Obtener listado completo, 2. Insertar");
                    int accionVentaCliente = in.nextInt();
                    in.nextLine();

                    switch (accionVentaCliente){
                        case 1:
                            System.out.println("Aqui esta la lista al completo: ");
                            //ventaClienteDAOImpl.getAll().forEach(System.out::println);
                            break;
                        case 2:
                            System.out.println("Introduce los datos necesarios: VENTA_ID Y CLIENTE_ID");
                            System.out.println("ventaID:");
                            int vId = in.nextInt();
                            in.nextLine();

                            System.out.println("clienteID");
                            int cId = in.nextInt();
                            in.nextLine();

                           // ventaClienteDAOImpl.saveVentaCliente(vId, cId);
                            break;
                        default:
                            System.out.println("OPCION INCORRECTA");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("SALIENDO DEL MENU");
                    break;

                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
        }while (opcionTabla != 5);
    }
}