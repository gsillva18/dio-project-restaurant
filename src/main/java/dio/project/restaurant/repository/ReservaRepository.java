package dio.project.restaurant.repository;

import dio.project.restaurant.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value = "select count(*) from tb_reserva tbr join tb_mesa tbm on tbr.mesa_fk = tbm.id where tbm.numero = :numero and tbr.status = 'ATIVA'", nativeQuery = true)
    public Integer verificarReservaAtiva(@Param("numero") Integer numero);
}
