package com.crudsa.ws;

import com.crudsa.vo.LibroVO;
import com.crudsa.dao.LibroDAO;
import com.crudsa.entity.Libro;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import javax.xml.ws.BindingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "libroService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class LibroServiceImpl implements LibroService{
    @Autowired
    private LibroDAO libroDao;
    
    private static final Logger logger = Logger.getLogger(LibroServiceImpl.class);
 
    
    @Override
    public String guardarLibro(int id, String nombre, String autor, String genero, String descripcion, String imagen) {
        Libro libro = new Libro();
        libro.setId(id);
        libro.setNombre(nombre);
        libro.setAutor(autor);
        libro.setGenero(genero);
        libro.setDescripcion(descripcion);
        libro.setImagen(imagen);
        libroDao.addLibro(libro);
        logger.info("LIBRO GUARDADO "+ libro.toString());
        return "Libro con nombre "+ libro.getNombre()+" fue guardado";
    }

    @Override
    public List<LibroVO> getLibroTitulo(String titulo) {
        List<LibroVO> libros = new ArrayList<>();
        List<Libro> lista = libroDao.getLibroNombre(titulo);
        for (Libro libro : lista) {
            LibroVO newLibro = copyLibro(libro);
            libros.add(newLibro);
        }
        logger.info("se obtienen los libros");
        return libros;
    }

    @Override
    public List<LibroVO> listaLibros(String par) {
        List<LibroVO> libros = new ArrayList<>();
        List<Libro> lista = libroDao.getAll();
        for (Libro libro : lista) {
            LibroVO newLibro = copyLibro(libro);
            libros.add(newLibro);
        }
        logger.info("se obtienen los libros");
        return libros;
    }

    @Override
    public LibroVO getLibro(int id) {
        LibroVO libroVO = new LibroVO();        
        Libro libro = libroDao.getLibro(id);
        if (libro != null) {
            libroVO = copyLibro(libro);
        }
        return libroVO;
    }

    @Override
    public String eliminarLibro(int id) {
        String mensaje;
        libroDao.deleteLibro(id);
        mensaje = "Libro eliminado ";
        return mensaje;
    }
    
    public Libro copyLibroVO(LibroVO libroVO){
        Libro libro = new Libro();
        libro.setId(libroVO.getId());
        libro.setNombre(libroVO.getNombre());
        libro.setAutor(libroVO.getAutor());
        libro.setDescripcion(libroVO.getDescripcion());
        libro.setGenero(libroVO.getGenero());
        libro.setImagen(libroVO.getImagen());
        return libro;
    }
    
    public LibroVO copyLibro(Libro libro){
        LibroVO libroVO = new LibroVO();
        libroVO.setId(libro.getId());
        libroVO.setNombre(libro.getNombre());
        libroVO.setAutor(libro.getAutor());
        libroVO.setDescripcion(libro.getDescripcion());
        libroVO.setGenero(libro.getGenero());
        libroVO.setImagen(libro.getImagen());
        return libroVO;
    }
}
