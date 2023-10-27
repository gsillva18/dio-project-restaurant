package dio.project.restaurant.repository;

import dio.project.restaurant.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query(value = "select * from tb_pedido tbp join tb_mesa tbm on tbp.mesa_fk = tbm.id where tbm.numero = :numero and tbp.aberto = true", nativeQuery = true)
    public Optional<Pedido> buscarPedidoAberto(@Param("numero") Integer numero);

}
