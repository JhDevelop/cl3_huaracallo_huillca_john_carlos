package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model.Categoria;
import pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    

    @Autowired
    private CategoriaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(Long id){
        return ResponseEntity.ok(service.obtener(id)) != null ? ResponseEntity.ok(service.obtener(id)) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        return ResponseEntity.ok( service.listar());
    }

    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        return new ResponseEntity<>(service.guardar(categoria), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria){
        Categoria updatedCategoria = service.actualizar(categoria);
        return updatedCategoria != null ? ResponseEntity.ok(updatedCategoria) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(Long id){
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
