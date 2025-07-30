package instituto.bios.delcafe.dominio;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "productos")
@Inheritance(strategy = InheritanceType.JOINED)//paso fk a hijos
public class Producto {
    
    @Id
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
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @NotNull
    Boolean disponible;

    @NotNull
    @Min(value = 0) 
    @Column(nullable = false)
    BigDecimal precio;

    @Min(value = 1)
    @Column(nullable = false)
    Integer cantidad;

    @OneToMany(mappedBy = "producto")
    private Set<DetallePedido> detalles = new HashSet<>();

     public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetallePedido> detalles) {
        this.detalles = detalles;
    }

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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Producto(){
        
    }

    public Producto(String nombre, String descripcion, boolean disponible, BigDecimal precio,
            Integer cantidad, Categoria categoria) {
        //this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria=categoria;
    }
}
