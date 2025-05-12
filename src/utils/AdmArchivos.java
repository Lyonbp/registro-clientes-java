package utils;

import java.io.*;
import java.util.ArrayList;
import models.Cliente;

public class AdmArchivos {
    private static final String RUTA_ARCHIVO= "data/clientes.txt";

    public static void guardarCLientes(ArrayList<Cliente> clientes) throws IOException{
        try (PrintWriter pw= new PrintWriter(RUTA_ARCHIVO)) {
            for (Cliente c : clientes) {
                pw.println(c.getDni() + ", " + c.getNombre() + ", " + c.getEmail());
            }
        }
    }

    public static ArrayList<Cliente> cargarClientes() throws IOException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        File file = new File(RUTA_ARCHIVO);
        if(!file.exists()) return clientes;

        try(BufferedReader br= new BufferedReader(new FileReader(file))) {
            String linea;
            while((linea = br.readLine()) != null) {
                String [] datos= linea.split(",");
                clientes.add(new Cliente(datos[0], datos[1], datos[2]));

            }
        }
        return clientes;
    }
}
