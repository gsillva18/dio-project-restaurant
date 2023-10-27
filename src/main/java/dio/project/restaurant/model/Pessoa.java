package dio.project.restaurant.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String numeroCelular;
}
