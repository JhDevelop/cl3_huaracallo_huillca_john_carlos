package pe.edu.cibertec.cl3_huaracallo_huillca_john_carlos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "tbl_categoria")
@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long idCategoria;

    private String descripcion;

}