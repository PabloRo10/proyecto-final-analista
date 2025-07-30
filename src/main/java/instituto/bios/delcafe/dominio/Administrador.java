package instituto.bios.delcafe.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador extends Usuario{

    public Administrador(){}

    public Administrador(String nombreUsuario, String nombreCompleto, String claveAcceso, String correoElectronico){
        super(nombreUsuario, nombreCompleto, claveAcceso, correoElectronico);
    }
}