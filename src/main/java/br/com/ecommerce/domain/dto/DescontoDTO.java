package br.com.ecommerce.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DescontoDTO {

    @Length(max = 150, min = 5, message = "{desconto.descricao.length}")
    private String descricao;

    private double vlDesconto;

    private double vlPercentual;

    @NotBlank(message = "{desconto.dtinicio.not.blank}")
    private Date dtInicio;

    @NotBlank(message = "{desconto.dtfinal.not.blank}")
    private Date dtFinal;
}
