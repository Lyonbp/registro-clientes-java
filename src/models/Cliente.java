package models;

public class Cliente {
    private String dni;
    private String nombre;
    private String email;
    
    public Cliente(String dni, String nombre, String email) {
        this.dni=dni;
        this.nombre=nombre;
        this.email=email;
    }

    public String getDni() {return dni;}
    public String getNombre() {return nombre;}
    public String getEmail() {return email;}

    public void setNombre(String nombre) {this.nombre=nombre;}
    public void setEmail(String email) {this.email=email;}
}
