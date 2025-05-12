import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import models.Cliente;
import utils.*;
public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        cargarDatos();
        mostrarMenu();
    }

    private static void cargarDatos() {
        try {
            clientes=AdmArchivos.cargarClientes();
        }catch(IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n---Menu---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Guardar y Salir");
            System.out.println("Opcion: ");
            opcion= scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1: registrarCLiente(); break;
                case 2: listarClientes(); break;
                case 3: guardarYSalir(); break;
            }

        }while(opcion !=3);
    }
    private static void registrarCLiente() {
        System.out.println("DNI: ");
        String dni= scanner.nextLine();
        if(!Validaciones.validarDni(dni)) {
            System.out.println("DNI invalido. Debe tener 8 digitos");
            return;
        }

        System.out.println("Nombre: ");
        String nombre= scanner.nextLine();
        if(nombre.isEmpty()) {
            System.out.println("Nombre no puede estar vacio");
            return;
        }

        System.out.println("Email: ");
        String email= scanner.nextLine();
        if(email.isEmpty()) {
            System.out.println("Email invalido");
            return;
        }

        clientes.add(new Cliente(dni, nombre, email));
        System.out.println("Cliente registrado");
    }
    private static void listarClientes() {
        if(clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            
        }
        clientes.forEach(c-> System.out.println(c.getDni() + "-" + c.getNombre()+"-"+c.getEmail()));
    }
    private static void guardarYSalir() {
        try {
            AdmArchivos.guardarCLientes(clientes);
            System.out.println("Datos guardados");
        }catch(IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}