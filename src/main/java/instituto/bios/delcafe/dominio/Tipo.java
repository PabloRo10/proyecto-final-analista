package instituto.bios.delcafe.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "tipo_producto")
public class Tipo {

    @Id
    @Min(1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @Column(length = 25)
    String nombreTipo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Tipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public Tipo() {
    }

    public Tipo(@Min(1) Integer codigo, String nombreTipo) {
        this.codigo = codigo;
        this.nombreTipo = nombreTipo;
    }

}
