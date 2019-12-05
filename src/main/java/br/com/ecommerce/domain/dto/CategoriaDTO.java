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
public class CategoriaDTO {

    @Length(max = 50, min = 5, message = "{categoria.descricao.length}")
    private String descricao;
}
