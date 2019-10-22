package com.crudsa.dao;

import com.crudsa.entity.Libro;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LibroDAOImpl implements LibroDAO{
    
    private static final Logger logger = Logger.getLogger(LibroDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Libro> getAll() {
        List<Libro> lista = new ArrayList<>();
        try {            
            Query query = sessionFactory.getCurrentSession().createQuery("from Libro");
            lista = query.list();   
            logger.info("LISTA LIBROS ");    
        } catch (HibernateException e) {
            logger.info("ERROR AL LISTAR LIBROS "+ e.getMessage());  
        }
        return lista;
    }

    @Override
    public Libro getLibro(int id) {
        Libro libro = (Libro) sessionFactory.getCurrentSession().get(Libro.class,new Integer(id));
        return libro ;
    }

    @Override
    public void addLibro(Libro libro) {
        try {            
            sessionFactory.getCurrentSession().saveOrUpdate(libro);
            logger.info("Agrega libro ");    
        } catch (HibernateException e) {
            logger.info("ERROR: "+ e.getMessage());  
        }
    }

    @Override
    public void deleteLibro(int id) {
        Libro libro = (Libro) sessionFactory.getCurrentSession().load(Libro.class,new Integer(id));
        if (libro != null) {
            sessionFactory.getCurrentSession().delete(libro);
        }
    }

    @Override
    public Libro updateLibro(Libro libro) {
        sessionFactory.getCurrentSession().update(libro);
        return libro;
    }
    
    @Override
    public List<Libro> getLibroNombre(String nombre) {
        List<Libro> lista = new ArrayList<>();
        try {            
            Query query = sessionFactory.getCurrentSession().createQuery("from Libro where nombre like concat('%',:nombreLibro,'%')");
            query.setParameter("nombreLibro", nombre);
            lista = query.list();   
            logger.info("LISTA LIBROS CON NOMBRE: "+nombre);    
        } catch (HibernateException e) {
            logger.info("ERROR AL LISTAR LIBROS "+ e.getMessage());  
        }
        return lista;
    }
    
}
