package instituto.bios.delcafe.dominio;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @NotNull
    @PastOrPresent
    LocalDateTime fechaHora;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "estado_rastreo_codigo")
    private EstadoRastreo estadoRastreo;

    @OneToMany(mappedBy = "pedido")
    private Set<DetallePedido> detalles = new HashSet<>();

    @Transient // no guarda en BD ya que es un atributo calculable y varía según el pedido
    public BigDecimal getImporteTotal() {
        return detalles.stream()
        .map(d -> d.getProducto().precio.multiply(BigDecimal.valueOf(d.getCantidad())))// multiplica precio * cantidad
        .reduce(BigDecimal.ZERO, BigDecimal::add);// suma todos los subtotales
        //.map(d -> d.getPrecio().multiply(BigDecimal.valueOf(d.getCantidad()))) 
        //.reduce(BigDecimal.ZERO, BigDecimal::add); 
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoRastreo getEstadoRastreo(){
        return estadoRastreo;
    }

    public void setEstadoRastreo(EstadoRastreo estadoRastreo){
        this.estadoRastreo = estadoRastreo;
    }

    public Set<DetallePedido> getdetallePedido(){
        return detalles;
    }

    public void setdetallePedido(Set<DetallePedido> detalles){
        this.detalles = detalles;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Pedido() {
    }

    public Pedido(Integer codigo, LocalDateTime fechaHora, Cliente cliente, EstadoRastreo estadoRastreo) {
        this.codigo = codigo;
        this.fechaHora = fechaHora;
        this.cliente = cliente;     
        this.estadoRastreo = estadoRastreo;
    }

}