package com.miapp;

import java.util.Scanner;
import com.miapp.application.usecase.client.ClientUseCase;
import com.miapp.application.usecase.product.ProductUseCase;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.domain.repository.ProductRepository;
import com.miapp.infrastructure.database.ConnectionFactory;
import com.miapp.infrastructure.persistence.client.ClientRepositoryImpl;
import com.miapp.infrastructure.persistence.product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ClientUseCase clienteCasoUso = new ClientUseCase(repositorio);
        ProductRepository repositorioProduc = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        ProductUseCase productoCasoUso = new ProductUseCase(repositorioProduc);
        try (Scanner sc = new Scanner(System.in)){
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
                                    System.out.print("Ingrese el email del Cliente: ");
                                    String email = sc.nextLine();
                                    clienteCasoUso.registrarCliente(id, nombre, email);
                                    System.out.println("El cliente se ha registrado exitosamente.");     
                                    System.out.println("-----------------------------");
                                    System.out.println("");
                                    break;
                                case "2":
                                    System.out.print("Ingresa el ID del cliente que deseas buscar: ");
                                    int idBuscar = sc.nextInt();
                                    sc.nextLine();
                                    clienteCasoUso.obtenerCliente(idBuscar);
                                    System.out.println("");
                                    break;
                                case "3":
                                    System.out.print("Ingresa el ID del cliente que deseas editar: ");
                                    int idNuevo = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Ingresa el nuevo nombre del cliente: ");
                                    String NombreNuevo = sc.nextLine();
                                    System.out.print("Ingresa el nuevo email del cliente: ");
                                    String EmailNuevo = sc.nextLine();
                                    System.out.println("");
                                    System.out.println("Información anterior: ");
                                    clienteCasoUso.obtenerCliente(idNuevo);
                                    clienteCasoUso.actualizarCliente(idNuevo, NombreNuevo, EmailNuevo);
                                    System.out.println("");
                                    System.out.println("Informacón actualizada: ");
                                    clienteCasoUso.obtenerCliente(idNuevo);
                                    System.out.println("");
                                    break;
                                case "4":
                                    clienteCasoUso.listarClientes();
                                    System.out.println("");
                                    break;
                                case "5":
                                    System.out.print("Ingrese el ID del cliente que desea eliminar: ");
                                    int idEliminar = sc.nextInt();
                                    sc.nextLine();
                                    clienteCasoUso.eliminarCliente(idEliminar);
                                    System.out.println("El cliente ha sido eliminado exitosamente.");
                                    System.out.println("");
                                    break;
                                case "6":
                                    System.out.println("Salida exitosa.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Ingreso una opcion incorrecta, volviendo al menu principal.......");
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
                                    System.out.print("Ingrese el ID del producto que deseas buscar: ");
                                    int idBuscar = sc.nextInt();
                                    sc.nextLine();
                                    productoCasoUso.obtenerproducto(idBuscar);
                                    System.out.println("");
                                break;
                                case "3":
                                    System.out.print("Ingrese el ID del producto que deseas editar: ");
                                    int idNuevoProducto = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Ingresa el nuevo nombre del producto: ");
                                    String NombreProducto = sc.nextLine();
                                    System.out.print("Ingrea el nuevo stock del producto: ");
                                    int StockNuevo = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("");
                                    System.out.println("Informacion anterior: ");
                                    productoCasoUso.obtenerproducto(idNuevoProducto);
                                    productoCasoUso.actualizarproducto(idNuevoProducto, NombreProducto, StockNuevo);
                                    System.out.println("");
                                    System.out.println("Informacion actualizada: ");
                                    productoCasoUso.obtenerproducto(idNuevoProducto);
                                    System.out.println("");
                                    break;
                                case "4":
                                    productoCasoUso.listarproductos();
                                    break;
                                case "5":
                                    System.out.print("Ingresa el ID del producto que deseas eliminar: ");
                                    int idEliminar = sc.nextInt();
                                    sc.nextLine();
                                    productoCasoUso.eliminarproducto(idEliminar);
                                    System.out.println("El producto ha sido eliminado exitosamente.");
                                    System.out.println("");
                                    break;
                                case "6":
                                    System.out.println("Salida exitosa.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("La opcion seleccionada no existe, volviendo al menu principal.......");
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
            }while(!Menu.equals("3"));
        }
    }
}