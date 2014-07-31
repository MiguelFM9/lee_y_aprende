/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author MiguelAngel
 */
public class BeanPrestamo {

    private BeanUsuario beanUsuario;
    private BeanEjemplar beanEjemplar;
    private String fechaDevolucion;

    public BeanPrestamo(BeanUsuario beanUsuario, BeanEjemplar beanEjemplar, String fechaDevolucion) {
        this.beanUsuario = beanUsuario;
        this.beanEjemplar = beanEjemplar;
        this.fechaDevolucion = fechaDevolucion;
    }

    public BeanPrestamo() {
    }

    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public BeanEjemplar getBeanEjemplar() {
        return beanEjemplar;
    }

    public void setBeanEjemplar(BeanEjemplar beanEjemplar) {
        this.beanEjemplar = beanEjemplar;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
