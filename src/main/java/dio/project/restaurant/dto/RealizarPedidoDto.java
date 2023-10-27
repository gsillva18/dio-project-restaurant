package dio.project.restaurant.dto;

import dio.project.restaurant.model.Bebida;
import dio.project.restaurant.model.Prato;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RealizarPedidoDto {

    private List<Prato> pratos;
    private List<Bebida> bebidas;
    private Integer numeroMesa;
}
