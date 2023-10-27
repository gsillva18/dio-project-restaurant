package dio.project.restaurant.service;

import dio.project.restaurant.model.Pessoa;
import dio.project.restaurant.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Com as anotações @Autowired e @Service se fazem uso dos padrões de projeto Singleton e Strategy
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa criarPessoa(String nome, String numeroCelular){

        //busca a pessoa pelo nome, caso não encontre cria uma nova
        Pessoa pessoa = repository.findPessoaByNome(nome).orElseGet(()->{

            Pessoa novaPessoa = new Pessoa();

            novaPessoa.setNome(nome);
            novaPessoa.setNumeroCelular(numeroCelular);

            return repository.save(novaPessoa);
        });

        return pessoa;

    }

}
