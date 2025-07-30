package instituto.bios.delcafe.dominio;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accesorios")
public class Accesorio extends Producto{

    public Accesorio(){
    }

    public Accesorio(String nombre, String descripcion, Boolean disponible, BigDecimal precio, Integer cantidad, Categoria categoria){
         super(nombre, descripcion, disponible, precio, cantidad, categoria);
    }
}
