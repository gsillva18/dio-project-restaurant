package dio.project.restaurant.model;

import dio.project.restaurant.core.enums.StatusReserva;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_RESERVA")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @ManyToOne
    @JoinColumn(name = "pessoa_fk")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "mesa_fk")
    private Mesa mesa;

}
