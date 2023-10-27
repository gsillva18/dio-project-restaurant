package dio.project.restaurant.service;

import dio.project.restaurant.core.utils.ConversorDtoModel;
import dio.project.restaurant.dto.MesaDto;
import dio.project.restaurant.model.Mesa;
import dio.project.restaurant.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Com as anotações @Autowired e @Service se fazem uso dos padrões de projeto Singleton e Strategy
 */
@Service
public class MesaService {

    @Autowired
    private MesaRepository repository;

    public void criarMesa(MesaDto dto) throws Exception{

        if (!repository.findMesaByNumero(dto.getNumero()).isPresent()){
            repository.save(ConversorDtoModel.converter(dto));
        }else{
            throw new Exception("Mesa existente");
        }

    }

    public List<Mesa> buscarMesas(){
        return repository.findAll();
    }


    public Mesa buscarMesa(Integer numero) throws Exception{

        return repository.findMesaByNumero(numero).orElseThrow(() -> new Exception("Mesa não existente"));

    }

    public void deletarMesa(Integer numero) throws Exception{
        repository.delete(buscarMesa(numero));
    }
}
