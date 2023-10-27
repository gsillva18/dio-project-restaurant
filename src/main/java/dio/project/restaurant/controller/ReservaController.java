package dio.project.restaurant.controller;

import dio.project.restaurant.dto.ReservaDto;
import dio.project.restaurant.response.ResponseRestaurant;
import dio.project.restaurant.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/reservar")
    public ResponseEntity<ResponseRestaurant> reservar(@RequestBody ReservaDto dto){
        try {
            reservaService.reservar(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Reserva realizada com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @PostMapping("/concluir-reserva/{id}")
    public ResponseEntity<ResponseRestaurant> concluirReserva(@PathVariable("id") Integer idReserva){
        try {
            reservaService.concluirReserva(idReserva);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new ResponseRestaurant(HttpStatus.ACCEPTED, "Reserva concluida com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseRestaurant(HttpStatus.CONFLICT, e));
        }
    }

    @GetMapping("/reservas")
    public ResponseEntity<ResponseRestaurant> buscarReservas(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseRestaurant(HttpStatus.ACCEPTED, reservaService.buscarReservas()));
    }

}
