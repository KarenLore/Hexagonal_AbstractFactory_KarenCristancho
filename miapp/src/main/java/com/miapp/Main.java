package com.miapp;

import java.util.Scanner;
import com.miapp.application.usecase.client.ClientUseCase;
import com.miapp.application.usecase.product.ProductUseCase;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.domain.repository.ProductRepository;
import com.miapp.infrastructure.database.ConnectionFactory;
import com.miapp.domain.entity.Client;
import com.miapp.domain.entity.Product;
import com.miapp.infrastructure.persistence.client.ClientRepositoryImpl;
import com.miapp.infrastructure.persistence.product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ClientUseCase clienteCasoUso = new ClientUseCase(repositorio);
        ProductRepository repositorioProduc = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        ProductUseCase productoCasoUso = new ProductUseCase(repositorioProduc);
        try (Scanner sc = new Scanner(System.in)) {
            String Menu;
            do {
                String Menu_Clientes;
                String Menu_Productos;
                System.out.println("1. Ingresar al menú de Clientes");
                System.out.println("2. Ingresa al menú de Productos");
                System.out.println("3. Salir");
                System.out.print("Option: ");
                Menu = sc.nextLine();
                System.out.println("-----------------------------");
                switch (Menu) {
                    case "1":
                        do {
                            System.out.println("Menú de clientes");
                            System.out.println("1. Registrar cliente");
                            System.out.println("2. Buscar clientes");
                            System.out.println("3. Actualizar datos de un cliente");
                            System.out.println("4. Mostrar todos los clientes ");
                            System.out.println("5. Eliminar cliente");
                            System.out.println("6. Salir del menu");
                            System.out.print("Option: ");
                            Menu_Clientes = sc.nextLine();
                            System.out.println("-----------------------------");
                            System.out.println("");
                            switch (Menu_Clientes) {
                                case "1":
                                    int id = 0;
                                    System.out.print("Ingrese el Nombre del Cliente: ");
                                    String nombre = sc.nextLine();

                                    String email;
                                    do {
                                        System.out.print("Ingrese el email del Cliente: ");
                                        email = sc.nextLine();
                                        if (!email.contains("@")) {
                                            System.out
                                                    .println("Error: El email debe contener '@'. Intente nuevamente.");
                                        }
                                    } while (!email.contains("@")); 

                                    clienteCasoUso.registrarCliente(id, nombre, email);
                                    System.out.println("El cliente se ha registrado exitosamente.");
                                    System.out.println("-----------------------------");
                                    System.out.println("");

                                    break;
                                case "2":
                                    System.out.print("Ingrese ID del Cliente a buscar: ");
                                    int idBuscar = sc.nextInt();
                                    sc.nextLine();
                                    Client cliente = clienteCasoUso.obtenerCliente(idBuscar);
                                    if (cliente != null) {
                                        System.out.println(
                                                "Cliente encontrado " + "\nNombre: " + cliente.getName() + "\nCorreo: "
                                                        + cliente.getEmail());
                                    } else {
                                        System.out.println("Cliente no encontrado.");
                                    }
                                    break;
                                case "3":
                                    System.out.print("Ingrese el ID del cliente que deseas actualizar: ");
                                    int idNuevo = sc.nextInt();
                                    sc.nextLine();

                                    if (clienteCasoUso.obtenerCliente(idNuevo) != null) {
                                        System.out.print("Ingrese el nuevo nombre para el cliente: ");
                                        String NombreNuevo = sc.nextLine();

                                        String EmailNuevo;
                                        do {
                                            System.out.print("Ingrese el nuevo email del cliente: ");
                                            EmailNuevo = sc.nextLine();
                                            if (!EmailNuevo.contains("@")) {
                                                System.out.println(
                                                        "El email ingresado no es válido. Debe contener '@'. Intente nuevamente.");
                                            }
                                        } while (!EmailNuevo.contains("@"));

                                        System.out.println("");

                                        clienteCasoUso.actualizarCliente(idNuevo, NombreNuevo, EmailNuevo);
                                        System.out.println("Cliente actualizado correctamente.");
                                        clienteCasoUso.obtenerCliente(idNuevo);
                                    } else {
                                        System.out.println("El cliente con ID " + idNuevo + " no existe.");
                                    }
                                    System.out.println("-----------------------");
                                    break;
                                case "4":
                                    System.out.println("Listado de Clientes:");
                                    clienteCasoUso.listarClientes().forEach(c -> System.out
                                            .println("ID: " + c.getId() + " Nombre: " + c.getName() + " Correo: "
                                                    + c.getEmail()));
                                    System.out.println("-----------------------");
                                    break;
                                case "5":
                                    System.out.print("Ingrese el ID del cliente que desea eliminar: ");
                                    int idEliminar = sc.nextInt();
                                    sc.nextLine();

                                    if (clienteCasoUso.obtenerCliente(idEliminar) != null) {
                                        clienteCasoUso.eliminarCliente(idEliminar);
                                        System.out.println("El cliente ha sido eliminado exitosamente.");
                                    } else {
                                        System.out.println("El cliente con ID " + idEliminar + " no existe.");
                                    }

                                    System.out.println("-----------------------");
                                    break;
                                case "6":
                                    System.out.println("Salida exitosa.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println(
                                            "Ingreso una opcion incorrecta, volviendo al menu principal.......");
                                    System.out.println();
                                    break;
                            }
                        } while (!Menu_Clientes.equals("6"));
                        break;

                    case "2":
                        do {
                            System.out.println("Menú de productos");
                            System.out.println("1. Registrar un producto");
                            System.out.println("2. Buscar un producto");
                            System.out.println("3. Actualizar información de un producto");
                            System.out.println("4. Listar todos los productos");
                            System.out.println("5. Eliminar un producto");
                            System.out.println("6. Salir del menu");
                            System.out.print("Option: ");
                            Menu_Productos = sc.nextLine();
                            System.out.println("-----------------------------");
                            System.out.println("");
                            switch (Menu_Productos) {
                                case "1":
                                    int id = 0;
                                    System.out.print("Ingrese el nombre del producto: ");
                                    String name = sc.nextLine();
                                    System.out.print("Ingrese el stock del producto: ");
                                    int stock = sc.nextInt();
                                    sc.nextLine();
                                    productoCasoUso.registrarproducto(id, name, stock);
                                    System.out.println("El producto se ha registrado exitosamente.");
                                    System.out.println("");
                                    break;
                                case "2":
                                    System.out.print("Ingrese ID del Producto a buscar: ");
                                    int idBuscar = sc.nextInt();
                                    sc.nextLine();
                                    Product producto = productoCasoUso.obtenerproducto(idBuscar);
                                    if (producto != null) {
                                        System.out.println(
                                                "Producto encontrado " + "\nNombre: " + producto.getName() + "\nStock "
                                                        + producto.getStock());
                                    } else {
                                        System.out.println("Producto no encontrado.");
                                    }
                                    break;
                                case "3":
                                    System.out.print("Ingrese el ID del producto que deseas actualizar: ");
                                    int idNuevoProducto = sc.nextInt();
                                    sc.nextLine();

                                    if (productoCasoUso.obtenerproducto(idNuevoProducto) != null) {
                                        System.out.print("Ingresa el nuevo nombre del producto: ");
                                        String NombreProducto = sc.nextLine();
                                        System.out.print("Ingresa el nuevo stock del producto: ");
                                        int StockNuevo = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("");

                                        System.out.println("Información anterior: ");
                                        productoCasoUso.obtenerproducto(idNuevoProducto);

                                        productoCasoUso.actualizarproducto(idNuevoProducto, NombreProducto, StockNuevo);
                                        System.out.println("");

                                        System.out.println("Información actualizada: ");
                                        productoCasoUso.obtenerproducto(idNuevoProducto);
                                        System.out.println("");
                                    } else {
                                        System.out.println("El producto con ID " + idNuevoProducto + " no existe.");
                                    }
                                    System.out.println("-----------------------");
                                    break;
                                case "4":
                                    System.out.println("Listado de Productos:");
                                    productoCasoUso.listarproductos().forEach(p -> System.out
                                            .println("ID: " + p.getId() + "Nombre: " + p.getName() + "Stock: "
                                                    + p.getStock()));
                                    System.out.println("-----------------------");
                                    break;
                                case "5":
                                    System.out.print("Ingresa el ID del producto que deseas eliminar: ");
                                    int idEliminar = sc.nextInt();
                                    sc.nextLine();

                                    if (productoCasoUso.obtenerproducto(idEliminar) != null) {
                                        productoCasoUso.eliminarproducto(idEliminar);
                                        System.out.println("El producto ha sido eliminado exitosamente.");
                                    } else {
                                        System.out.println("El producto con ID " + idEliminar + " no existe.");
                                    }

                                    System.out.println("-----------------------");
                                    break;
                                case "6":
                                    System.out.println("Salida exitosa.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println(
                                            "La opcion seleccionada no existe, volviendo al menu principal.......");
                                    System.out.println();
                                    break;
                            }
                        } while (!Menu_Productos.equals("6"));
                        break;
                    case "3":
                        System.out.println("Salida exitosa.......");
                        System.out.println();
                        break;
                    default:
                        System.out.println("La opcion seleccionada no existe, volviendo al menu principal.......");
                        System.out.println();
                        break;
                }
            } while (!Menu.equals("3"));
        }
    }
}