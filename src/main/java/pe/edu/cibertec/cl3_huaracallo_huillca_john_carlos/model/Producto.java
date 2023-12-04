package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "tbl_producto")
@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    private String descripcion;

    private BigDecimal precio;

    private int stock;

    private int estado;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}