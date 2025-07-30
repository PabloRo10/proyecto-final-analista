package instituto.bios.delcafe.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario{ //NUEVO
    
    //@Id
    @Size(min = 8, max = 8)
    @Column(nullable = false, length = 8, unique = true)
    String cedula;

    @NotBlank
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    String domicilio; 

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    String telefono;

    @ManyToMany //NUEVO, creamos una nueva tabla con FK de cliente y FK evento tomando en cuenta la relacion N a N.
    @JoinTable(
        name = "cliente_eventos",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private Set<Evento> eventos = new HashSet<>();

    @ManyToMany//NUEVO
    @JoinTable(
        name = "cliente_plansuscripcion",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "plansuscripcion_id")
    )
    private Set<PlanSuscripcion> planes = new HashSet<>();

    @OneToMany(mappedBy = "cliente")//Nuevo
    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedido(){
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public Set<PlanSuscripcion> getPlanes(){ //NUEVO
        return planes;
    }

    public void setPlanes(Set<PlanSuscripcion> planes){ //Nuevo
        this.planes=planes;
    }

    public Set<Evento> getEventos(){
        return eventos;
    }

    public void setEvento(Set<Evento> eventos){
        this.eventos = eventos;
    }

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
    }

    public Cliente(String cedula, String domicilio, String telefono, List<Pedido> pedidos) {
        this.cedula = cedula;
        this.domicilio = domicilio;
        this.telefono = telefono;
        eventos = new HashSet<>(); //NUEVO
        planes = new HashSet<>(); //NUEVO
        this.pedidos=pedidos;
    }

     public Cliente(String nombreUsuario,@NotBlank String nombreCompleto,@NotBlank String claveAcceso, String correoElectronico, String cedula, String domicilio, String telefono, List<Pedido> pedidos){
        super(nombreUsuario, nombreCompleto, claveAcceso, correoElectronico);
        this.cedula = cedula;
        this.domicilio = domicilio;
        this.telefono = telefono;
        eventos = new HashSet<>(); //NUEVO
        planes = new HashSet<>(); //NUEVO
        this.pedidos=pedidos;
    }
}
