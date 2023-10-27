package dio.project.restaurant.controller;

import dio.project.restaurant.dto.ConcluirPedidoDto;
import dio.project.restaurant.dto.RealizarPedidoDto;
import dio.project.restaurant.response.ResponseRestaurant;
import dio.project.restaurant.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/realizar-pedido")
    public ResponseEntity<ResponseRestaurant> realizarPedido(@RequestBody RealizarPedidoDto dto){

        try {
            pedidoService.realizarPedido(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Pedido realizado com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }

    }

    @PostMapping("/concluir-pedido")
    public ResponseEntity<ResponseRestaurant> concluirPedido(@RequestBody ConcluirPedidoDto dto){

        try {
            pedidoService.concluirPedido(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Pedido concluido com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }

    }

    @GetMapping("/valor-pedido/{id}")
    public ResponseEntity<ResponseRestaurant> valorPedido(@PathVariable("id") Integer idPedido){

        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, pedidoService.valorTotalPagar(idPedido)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }

    }

    @GetMapping("/pedidos")
    public ResponseEntity<ResponseRestaurant> buscarPedidos(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseRestaurant(HttpStatus.ACCEPTED, pedidoService.buscarPedidos()));

    }


}
