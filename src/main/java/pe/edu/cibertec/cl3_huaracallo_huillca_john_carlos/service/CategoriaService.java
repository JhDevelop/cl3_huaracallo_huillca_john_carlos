package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model.Categoria;
import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository repository;


    @Override
    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria actualizar(Categoria categoria) {
        if(!repository.existsById(categoria.getIdCategoria())){
            throw new RuntimeException("Categoria no encontrada");
        }
        return repository.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("Categoria no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public Categoria obtener(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        if(categoria.isEmpty()){
            throw new RuntimeException("Categoria no encontrada");
        }
        return categoria.get();
    }

    @Override
    public List<Categoria> listar() {
        return (List<Categoria>) repository.findAll();
    }

}
