package instituto.bios.delcafe.dominio;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED) //NUEVO: es una estrategia de mapeo que crea una tabla para cada clase en la jerarquía, y las relaciona mediante claves foráneas (JOIN).
public class Usuario {
    
    @NotBlank
    @Id
    @Size(min = 5, max = 25)
    @Column(length = 25, unique = true)
    String nombreUsuario;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    String nombreCompleto;

    @NotBlank
    @Size(min = 5, max = 80) //cambio según RNE de MC
    @Column(nullable = false, length = 80) //cambio según RNE de MC y se puso 80 porque la encriptacion tiene bastantes caracteres
    String claveAcceso;

    @Size(max = 60)
    @Column(unique = true, nullable = false, length = 60) //Le decimos que el correo sea unico e irrepetible segun MC
    String correoElectronico; 

    @ManyToMany//NUEVO, creamos una nueva tabla para asignar permisos y responsabilidades entre distintos usuarios
    @JoinTable(
        name = "usuario_roles",
        joinColumns = { @JoinColumn(name = "usuario_id") },
        inverseJoinColumns ={ @JoinColumn(name = "rol_id") }
    )
    private Set<Rol> roles; //NUEVO

      public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {//NUEVO
        this.roles = roles;
    }
    

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

    public Usuario(@NotBlank String nombreUsuario,@NotBlank String nombreCompleto,@NotBlank String claveAcceso, String correoElectronico) { //NUEVO
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.claveAcceso = claveAcceso;
        this.correoElectronico = correoElectronico;
        roles = new HashSet<>();//NUEVO
    }

}
