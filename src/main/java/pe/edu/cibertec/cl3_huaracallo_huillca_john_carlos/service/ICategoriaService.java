package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.service;

import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    Categoria guardar(Categoria categoria);

    Categoria actualizar(Categoria categoria);

    void eliminar(Long id);

    Categoria obtener(Long id);

    List<Categoria> listar();
}
