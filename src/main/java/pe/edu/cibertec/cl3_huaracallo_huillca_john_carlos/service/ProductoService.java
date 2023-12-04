package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model.Producto;
import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto guardar(Producto producto) {
        if(validar(producto)){
            throw new RuntimeException("Producto no encontrado");
        }
        return repository.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        if (!repository.existsById(producto.getIdProducto())) {
            throw new RuntimeException("Producto no encontrado");
        }if (validar(producto)) {
            throw new RuntimeException("Producto no encontrado");
        }
        return repository.save(producto);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public List<Producto> listar() {
        return (List<Producto>) repository.findAll();
    }

    @Override
    public Producto obtener(Long id){

        Optional<Producto> producto = repository.findById(id);
        if(producto.isEmpty()){
            throw new RuntimeException("Producto no encontrado");
        }
        return producto.get();
    }

    private boolean validar(Producto producto) {
        if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
            throw new RuntimeException("El nombre es obligatorio");
        }
        if (producto.getPrecio() == null && producto.getPrecio().compareTo(null) <= 0) {
            throw new RuntimeException("El precio es obligatorio");
        }
        if (producto.getStock() >= 0|| producto.getStock() <= 0) {
            throw new RuntimeException("El stock es obligatorio");
        }
        return true;
    }
}
