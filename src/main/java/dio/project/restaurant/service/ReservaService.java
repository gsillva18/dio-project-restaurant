package dio.project.restaurant.service;

import dio.project.restaurant.core.enums.StatusReserva;
import dio.project.restaurant.dto.ReservaDto;
import dio.project.restaurant.model.Mesa;
import dio.project.restaurant.model.Pessoa;
import dio.project.restaurant.model.Reserva;
import dio.project.restaurant.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Com as anotações @Autowired e @Service se fazem uso dos padrões de projeto Singleton e Strategy
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private MesaService mesaService;

    public void reservar(ReservaDto dto) throws Exception {

        //verificar se a mesa com esse número está em reserva com status ativa
        if (repository.verificarReservaAtiva(dto.getNumeroMesa()) != 0){
            throw new Exception("Mesa já reservada");
        }

        //se não estiver ativa, criar pessoa e salvar no banco
        Pessoa pessoa = pessoaService.criarPessoa(dto.getNome(), dto.getNumeroCelular());

        //buscar mesa
        Mesa mesa = mesaService.buscarMesa(dto.getNumeroMesa());

        //criar reserva
        Reserva reserva = new Reserva();
        reserva.setMesa(mesa);
        reserva.setPessoa(pessoa);
        reserva.setDataHora(LocalDateTime.now());
        reserva.setStatus(StatusReserva.ATIVA);

        //adicionar reserva no banco
        repository.save(reserva);
    }

    public void concluirReserva(Integer idReserva) throws Exception{

        //buscar reserva, caso ela exista
        Reserva reserva = repository.findById(idReserva).orElseThrow(()-> new Exception("Reserva não encontrada"));

        //coloca o status para inativa
        reserva.setStatus(StatusReserva.INATIVA);

        //salvar no banco
        repository.save(reserva);
    }

    public List<Reserva> buscarReservas(){
        return repository.findAll();
    }
}
