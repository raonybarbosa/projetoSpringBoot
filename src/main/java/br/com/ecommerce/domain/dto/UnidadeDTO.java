package br.com.ecommerce.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeDTO {

    @Length(max = 10, min = 1, message = "{unidade.descricao.length}")
    private String descricao;
}
