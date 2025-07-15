package instituto.bios.delcafe.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @Size(min = 8, max = 8)
    @Column(nullable = false, length = 8)
    String cedula;

    @NotBlank
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    String domicilio; 

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    String telefono;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente() {
        this(null, null, null);
    }

    public Cliente(String cedula, String domicilio, String telefono) {
        this.cedula = cedula;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

}
