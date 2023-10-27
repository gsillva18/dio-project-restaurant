package dio.project.restaurant.controller;

import dio.project.restaurant.dto.MesaDto;
import dio.project.restaurant.response.ResponseRestaurant;
import dio.project.restaurant.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-mesas")
public class AdiministracaoMesaController {

    @Autowired
    private MesaService mesaService;

    @PostMapping("/adicionar-mesa")
    public ResponseEntity<ResponseRestaurant> adicionarMesa(@RequestBody MesaDto dto){
        try {
            mesaService.criarMesa(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Mesa adicionada com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @DeleteMapping("/deletar-mesa/{numero}")
    public ResponseEntity<ResponseRestaurant> deletarMesa(@PathVariable("numero") Integer numero){
        try {
            mesaService.deletarMesa(numero);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Mesa deletada com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-mesa/{numero}")
    public ResponseEntity<ResponseRestaurant> buscarMesa(@PathVariable("numero") Integer numero){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, mesaService.buscarMesa(numero)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-mesas")
    public ResponseEntity<ResponseRestaurant> buscarMesas(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseRestaurant(HttpStatus.ACCEPTED, mesaService.buscarMesas()));
    }


}
