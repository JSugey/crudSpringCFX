package com.crudsa.ws;

import com.crudsa.vo.LibroVO;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface LibroService {
    
    @WebMethod
    public String guardarLibro(@WebParam(name="id") int id, @WebParam(name="nombre") String nombre,@WebParam(name="autor") String autor,
                            @WebParam(name="genero") String genero,@WebParam(name="descripcion") String descripcion,@WebParam(name="imagen") String imagen);

    @WebMethod
    public List<LibroVO> getLibroTitulo(@WebParam(name="titulo") String titulo);
    
    @WebMethod
    public List<LibroVO> listaLibros(String par);
    
    @WebMethod
    public LibroVO getLibro(@WebParam(name="id") int id);
    
    @WebMethod
    public String eliminarLibro(@WebParam(name="id") int id);
        
}
