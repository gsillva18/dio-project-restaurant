package dio.project.restaurant.service;

import dio.project.restaurant.core.utils.ConversorDtoModel;
import dio.project.restaurant.dto.BebidaDto;
import dio.project.restaurant.model.Bebida;
import dio.project.restaurant.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Com as anotações @Autowired e @Service se fazem uso dos padrões de projeto Singleton e Strategy
 */
@Service
public class BebidaService {

    @Autowired
    private BebidaRepository repository;

    public void adicionarBebida(BebidaDto dto) throws Exception{

        if(!repository.findBebidaByNome(dto.getNome()).isPresent()){
            repository.save(ConversorDtoModel.converter(dto));
        }else{
            throw new Exception("Bebida já existente");
        }
    }

    public void atualizarBebida(Bebida bebida){
        repository.save(bebida);
    }

    public Bebida buscarBebida(Integer id) throws Exception{
        return repository.findById(id).orElseThrow(()-> new Exception("Bebida não encontrada"));
    }

    public List<Bebida> buscarBebidas(){
        return repository.findAll();
    }

    public void removerBebida(Integer id) throws Exception{
        repository.delete(buscarBebida(id));
    }

}
