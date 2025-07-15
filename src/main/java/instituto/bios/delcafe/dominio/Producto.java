package instituto.bios.delcafe.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @Min(1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    String nombre;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    String descripcion; 

    @NotNull
    @ManyToOne(optional = false)
    private Categoria categoria;

    boolean disponible;

    @NotNull
    @Min(value = 0) 
    @Column(nullable = false)
    Double precio;

    @Min(value = 1)
    @Column(nullable = false)
    Integer cantidad;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto(Integer codigo, String nombre, String descripcion, boolean disponible, Double precio,
            Integer cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}
