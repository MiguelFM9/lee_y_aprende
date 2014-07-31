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
public class BeanLibro {
    private String isbn;
    private String titulo;
    private int num_pag;
    private BeanEditorial editorial;
    private BeanArea area;
    private BeanAutor autor;

    public BeanLibro() {
    }

    public BeanLibro(String isbn, String titulo, int num_pag, BeanEditorial editorial, BeanArea area, BeanAutor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.num_pag = num_pag;
        this.editorial = editorial;
        this.area = area;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNum_pag() {
        return num_pag;
    }

    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag;
    }

    public BeanEditorial getEditorial() {
        return editorial;
    }

    public void setEditorial(BeanEditorial editorial) {
        this.editorial = editorial;
    }

    public BeanArea getArea() {
        return area;
    }

    public void setArea(BeanArea area) {
        this.area = area;
    }

    public BeanAutor getAutor() {
        return autor;
    }

    public void setAutor(BeanAutor autor) {
        this.autor = autor;
    }

    

}
