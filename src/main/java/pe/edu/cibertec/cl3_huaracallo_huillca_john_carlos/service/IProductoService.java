package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.service;

import java.util.List;
import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model.Producto;

public interface IProductoService {

    Producto guardar(Producto Producto);

    Producto actualizar(Producto Producto);

    void eliminar(Long id);

    Producto obtener(Long id);

    List<Producto> listar();
}
