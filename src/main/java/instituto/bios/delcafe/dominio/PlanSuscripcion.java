package instituto.bios.delcafe.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "planSuscripciones")
public class PlanSuscripcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    String nombre; 

    @NotNull
    @Min(value = 1)//cambio
    @Column(nullable = false)
    Double precio; 

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false, length = 500)
    String descripcion; 

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PlanSuscripcion() {
        this(null, null, null);
    }

    public PlanSuscripcion(String nombre, Double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

}
