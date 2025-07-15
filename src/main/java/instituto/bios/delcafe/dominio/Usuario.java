package instituto.bios.delcafe.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @NotBlank
    @Id
    @Size(min = 5, max = 25)
    @Column(length = 25)
    String nombreUsuario;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    String nombreCompleto;

    @NotBlank
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    String claveAcceso;

    @Size(max = 60)
    @Column(nullable = false, length = 60)
    String correoElectronico; 

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Usuario() {
        this(null, null, null, null);
    }

    public Usuario(String nombreUsuario, String nombreCompleto, String claveAcceso, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.claveAcceso = claveAcceso;
        this.correoElectronico = correoElectronico;
    }

}
