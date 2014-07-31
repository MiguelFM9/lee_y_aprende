/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author Usuario
 */
public class BeanUsuario {
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private String Email;
    private String tipo_usuario;

    public BeanUsuario() {
    }

    public BeanUsuario(String Nombre, String Direccion, String Telefono, String Email, String tipo_usuario) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.tipo_usuario = tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

   

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getEmail() {
        return Email;
    }
    
    
}
