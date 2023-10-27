package dio.project.restaurant.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ConcluirPedidoDto {

    private Integer idPedido;
    private Integer idFormaPagamento;
    private BigDecimal desconto;
    private String numeroCelular;
}
