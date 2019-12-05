package br.com.ecommerce.domain;

import br.com.ecommerce.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Desconto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(name = "descricao", length = 150, nullable = false)
    private String descricao;

    @Column(name = "vlDesconto", nullable = true)
    private double vlDesconto;

    @Column(name = "vlPercentual", nullable = true)
    private double vlPercentual;

    @Column(name = "dtInicio", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtInicio;

    @Column(name = "dtFinal", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtFinal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 1, nullable = false)
    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany
    private List<Produto> produtos;
}