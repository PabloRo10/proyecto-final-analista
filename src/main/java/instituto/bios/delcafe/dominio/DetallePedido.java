package instituto.bios.delcafe.dominio;

//import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detallesPedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Min(value = 1)
    @Column(nullable = false)
    private Integer cantidad;

   /*@NotNull
    @Min(value = 1)
    @Column(nullable = false)
    private BigDecimal precio;

    public BigDecimal getPrecio(){
        return precio;
    }  

    public void setPrecio(BigDecimal precio){
        this.precio= precio;
    }*/

    public Integer getCodigo(){
        return codigo;
    }

    public void setCodigo(Integer codigo){
        this.codigo= codigo;
    }

    public Pedido getPedido(){
        return pedido;
    }

    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }

    public Producto getProducto(){
        return producto;
    }

    public void setProducto(Producto producto){
        this.producto= producto;
    }

    public Integer getCantidad(){
        return cantidad;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad= cantidad;
    }

    public DetallePedido(){
    }

    public DetallePedido(Pedido pedido, Producto producto, Integer cantidad /*BigDecimal precio*/){
        //this.codigo = codigo;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        //this.precio = precio;
    }

}
