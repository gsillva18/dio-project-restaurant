package dio.project.restaurant.controller;

import dio.project.restaurant.dto.FormaPagamentoDto;
import dio.project.restaurant.response.ResponseRestaurant;
import dio.project.restaurant.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-forma-pagamento")
public class AdiministracaoFormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping("/adicionar-forma-pagamento")
    public ResponseEntity<ResponseRestaurant> adicionarFormaPagamento(@RequestBody FormaPagamentoDto dto){
        try {
            formaPagamentoService.criarFormaPagamento(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Forma Pagamento adicionada com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @DeleteMapping("/deletar-forma-pagamento/{id}")
    public ResponseEntity<ResponseRestaurant> deletarFormaPagamento(@PathVariable("id") Integer id){
        try {
            formaPagamentoService.deleteFormaPagamento(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Forma Pagamento deletada com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-forma-pagamento/{id}")
    public ResponseEntity<ResponseRestaurant> buscarFormaPagamento(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, formaPagamentoService.buscarFormaPagamento(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-formas-pagamento")
    public ResponseEntity<ResponseRestaurant> buscarFormasPagamento(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseRestaurant(HttpStatus.ACCEPTED, formaPagamentoService.buscarFormasPagamentos()));
    }


}
