package dio.project.restaurant.service;

import dio.project.restaurant.core.utils.ConversorDtoModel;
import dio.project.restaurant.dto.PratoDto;
import dio.project.restaurant.model.Prato;
import dio.project.restaurant.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Com as anotações @Autowired e @Service se fazem uso dos padrões de projeto Singleton e Strategy
 */
@Service
public class PratoService {

    @Autowired
    private PratoRepository repository;

    public void criarPrato(PratoDto dto) throws Exception{

        if(!repository.findPratoByNome(dto.getNome()).isPresent()){
            repository.save(ConversorDtoModel.converter(dto));
        }else{
            throw new Exception("Prato já existente");
        }
    }

    public void atualizarPrato(Prato prato){
        repository.save(prato);
    }

    public Prato buscarPrato(Integer id) throws Exception{
        return repository.findById(id).orElseThrow(()-> new Exception("Prato não encontrado"));
    }

    public List<Prato> buscarPratos(){
        return repository.findAll();
    }

    public void deletePrato(Integer id) throws Exception{
        repository.delete(buscarPrato(id));
    }
}
