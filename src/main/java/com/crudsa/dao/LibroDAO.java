package com.crudsa.dao;

import java.util.List;
import com.crudsa.entity.Libro;

public interface LibroDAO {
    List<Libro> getAll();
    
    Libro getLibro(int id);
    
    void addLibro(Libro libro);

    void deleteLibro(int id);
    
    Libro updateLibro(Libro libro);
    
    List<Libro> getLibroNombre(String nombre);
}
