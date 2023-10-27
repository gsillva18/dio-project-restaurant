package dio.project.restaurant.repository;

import dio.project.restaurant.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    public Optional<Mesa> findMesaByNumero(Integer numero);
}
