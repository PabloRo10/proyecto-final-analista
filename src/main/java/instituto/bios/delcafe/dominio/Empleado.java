package instituto.bios.delcafe.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado extends Usuario{

    public Empleado(){}

    public Empleado(String nombreUsuario, String nombreCompleto, String claveAcceso, String correoElectronico){
        super(nombreUsuario, nombreCompleto, claveAcceso, correoElectronico);
    }
}
