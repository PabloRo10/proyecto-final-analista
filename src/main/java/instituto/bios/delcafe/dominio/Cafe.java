package instituto.bios.delcafe.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cafes")
public class Cafe {
    
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

    public Cafe() {
        this(null);
    }

    public Cafe(String origen) {
        this.origen = origen;
    }

}
