package instituto.bios.delcafe.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @Min(1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @Column(nullable = false)
    LocalDateTime fechaHoraRealizada;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaHoraRealizada() {
        return fechaHoraRealizada;
    }

    public void setFechaHoraRealizada(LocalDateTime fechaHoraRealizada) {
        this.fechaHoraRealizada = fechaHoraRealizada;
    }

    public Pedido() {
        this(null, null);
    }

    public Pedido(Integer codigo, LocalDateTime fechaHoraRealizada) {
        this.codigo = codigo;
        this.fechaHoraRealizada = fechaHoraRealizada;
    }

}
