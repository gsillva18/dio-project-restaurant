package dio.project.restaurant.repository;

import dio.project.restaurant.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    public Optional<Pessoa> findPessoaByNome(String nome);
}
