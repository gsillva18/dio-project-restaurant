package dio.project.restaurant.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_MESA")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidadeLugares;
    private Integer numero;

}
