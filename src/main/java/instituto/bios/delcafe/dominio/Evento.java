package instituto.bios.delcafe.dominio;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "eventos")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    String nombre;

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false, length = 500)
    String descripcion;

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false, length = 500)
    String direccion;

    @NotBlank
    @Min(value = 0)
    @Column(nullable = false)
    Integer cupo;

    @ManyToMany(mappedBy = "eventos")//NUEVO, mapeo para ser bidireccional y acceder de ambas entidades.
    private Set<Cliente> clientes = new HashSet<>();

    public Set<Cliente> getCliente(){//NUEVO
        return clientes;
    }
    
    public void SetCliente(Set<Cliente> clientes){//NUEVO
        this.clientes = clientes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Evento() {
    }

    public Evento(String nombre, String descripcion, String direccion, Integer cupo) {
        //this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.cupo = cupo;
    }
    
}
