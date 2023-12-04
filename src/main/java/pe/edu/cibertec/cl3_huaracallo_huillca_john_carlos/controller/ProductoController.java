package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model.Producto;
import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService service;


    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        return ResponseEntity.ok( service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(Long id){
        return ResponseEntity.ok(service.obtener(id)) != null ? ResponseEntity.ok(service.obtener(id)) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(Producto producto){
        return new ResponseEntity<>(service.guardar(producto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producto> actualizar(Producto producto){
        Producto updatedProducto = service.actualizar(producto);
        return updatedProducto != null ? ResponseEntity.ok(updatedProducto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(Long id){
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
