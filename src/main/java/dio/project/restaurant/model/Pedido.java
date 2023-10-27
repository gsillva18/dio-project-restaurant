package dio.project.restaurant.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    private Boolean aberto = true;

    @ManyToOne
    @JoinColumn(name = "mesa_fk")
    private Mesa mesa;

    @ManyToMany
    @JoinTable(
            name = "TB_PEDIDO_PRATO",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "prato_id")
    )
    private List<Prato> pratos;

    @ManyToMany
    @JoinTable(
            name = "TB_PEDIDO_BEBIDA",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "bebida_id")
    )
    private List<Bebida> bebidas;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_fk")
    private FormaPagamento formaPagamento;

    public BigDecimal valorTotal(){

        BigDecimal total = BigDecimal.ZERO;

        for(Prato prato: pratos){
            total = total.add(prato.getValor());
        }

        for(Bebida bebida: bebidas){
            total = total.add(bebida.getValor());
        }

        return total;
    }

}
