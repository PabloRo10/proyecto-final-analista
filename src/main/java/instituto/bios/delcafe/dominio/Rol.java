package instituto.bios.delcafe.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
    
    @Id
    @Column(length = 25)
    String nombreRol;

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public Rol() {
        this(null);
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

}
