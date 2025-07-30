package instituto.bios.delcafe.dominio;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cafes")
public class Cafe extends Producto{
    
    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    String origen;

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Cafe(){
    }

    public Cafe(String origen) {
        this.origen = origen;
    }

    public Cafe(String nombre, String descripcion, Boolean disponible, BigDecimal precio, Integer cantidad, Categoria categoria, String origen){
         super(nombre, descripcion, disponible, precio, cantidad, categoria);
        this.origen = origen;
    }
}
