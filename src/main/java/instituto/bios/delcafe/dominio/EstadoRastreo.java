package instituto.bios.delcafe.dominio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "estados_rastreo")
public class EstadoRastreo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Pattern( //usamos pattern con expresion regular
        regexp = "en preparación|en camino|entregado",
        message = "La descripción debe ser 'en preparación', 'en camino' o 'entregado'"
    )
    private String descripcion;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoRastreo() {
        this(null, null);
    }

    public EstadoRastreo(Integer codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
}
