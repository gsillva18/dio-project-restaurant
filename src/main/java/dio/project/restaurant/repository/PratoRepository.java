package dio.project.restaurant.repository;

import dio.project.restaurant.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer> {

    public Optional<Prato> findPratoByNome(String nome);
}
