package dio.project.restaurant.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_FORMA_PAGAMENTO")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
}
