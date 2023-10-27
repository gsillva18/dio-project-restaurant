package dio.project.restaurant.service;

import dio.project.restaurant.core.utils.ConversorDtoModel;
import dio.project.restaurant.dto.FormaPagamentoDto;
import dio.project.restaurant.model.FormaPagamento;
import dio.project.restaurant.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Com as anotações @Autowired e @Service se fazem uso dos padrões de projeto Singleton e Strategy
 */
@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository repository;

    public void criarFormaPagamento(FormaPagamentoDto dto) throws Exception{

        if (!repository.findFormaPagamentoByNome(dto.getNome()).isPresent()){
            repository.save(ConversorDtoModel.converter(dto));
        }else{
            throw new Exception("Forma de pagamento já existente");
        }
    }

    public FormaPagamento buscarFormaPagamento(Integer id) throws Exception{

        return repository.findById(id).orElseThrow(()-> new Exception("Forma de pagamento não encontrada"));
    }

    public List<FormaPagamento> buscarFormasPagamentos(){
        return repository.findAll();
    }

    public void deleteFormaPagamento(Integer id) throws Exception{
        repository.delete(buscarFormaPagamento(id));
    }
}
