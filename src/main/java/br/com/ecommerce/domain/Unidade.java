package br.com.ecommerce.domain;

import br.com.ecommerce.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(name = "descricao", length = 10, nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 1, nullable = false)
    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany
    private List<Produto> produtos;
}