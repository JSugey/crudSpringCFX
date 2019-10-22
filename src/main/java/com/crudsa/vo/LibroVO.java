
package com.crudsa.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Libro")
public class LibroVO {
    private int id;
    private String nombre;
    private String autor;
    private String genero;
    private String descripcion;
    private String imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public String toString(){        
        return "Id: "+id+"\n"+
               "Libro: "+nombre+"\n"+
               "Autor: "+autor+"\n"+
               "Genero: "+genero+"\n";
    }
}
