package dio.project.restaurant.repository;

import dio.project.restaurant.model.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer> {

    public Optional<Bebida> findBebidaByNome(String nome);
}
