package com.tienda.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data // generar por debajo los set y get
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name = "idCategoria", insertable = false, updatable = false)
    private List<Producto> productos;
    
    public Categoria(){
        
    }
    
    public Categoria(String descripcion, boolean activo, String rutaImagen){
        
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
}
