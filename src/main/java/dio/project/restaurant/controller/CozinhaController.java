package dio.project.restaurant.controller;

import dio.project.restaurant.dto.BebidaDto;
import dio.project.restaurant.dto.PratoDto;
import dio.project.restaurant.response.ResponseRestaurant;
import dio.project.restaurant.service.BebidaService;
import dio.project.restaurant.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cozinha")
public class CozinhaController {

    @Autowired
    private PratoService pratoService;
    @Autowired
    private BebidaService bebidaService;

    @PostMapping("/adicionar-prato")
    public ResponseEntity<ResponseRestaurant> adicionarPrato(@RequestBody PratoDto dto){
        try {
            pratoService.criarPrato(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "prato adicionado com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @DeleteMapping("/delete-prato/{id}")
    public ResponseEntity<ResponseRestaurant> removerPrato(@PathVariable("id") Integer id){
        try {
            pratoService.deletePrato(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "prato removido com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-prato/{id}")
    public ResponseEntity<ResponseRestaurant> buscarPrato(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, pratoService.buscarPrato(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-pratos")
    public ResponseEntity<ResponseRestaurant> buscarPratos(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseRestaurant(HttpStatus.ACCEPTED, pratoService.buscarPratos()));
    }

    @PostMapping("/adicionar-bebida")
    public ResponseEntity<ResponseRestaurant> adicionarBebida(@RequestBody BebidaDto dto){
        try {
            bebidaService.adicionarBebida(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "bebida adicionada com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @DeleteMapping("/delete-bebida/{id}")
    public ResponseEntity<ResponseRestaurant> removerBebida(@PathVariable("id") Integer id){
        try {
            bebidaService.removerBebida(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "bebida removida com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-bebida/{id}")
    public ResponseEntity<ResponseRestaurant> buscarBebida(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, bebidaService.buscarBebida(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/buscar-bebidas")
    public ResponseEntity<ResponseRestaurant> buscarBebidas(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseRestaurant(HttpStatus.ACCEPTED, bebidaService.buscarBebidas()));
    }
}
