package dio.project.restaurant.repository;

import dio.project.restaurant.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {

    public Optional<FormaPagamento> findFormaPagamentoByNome(String nome);
}
