package br.com.ecommerce.domain.dto;

import br.com.ecommerce.domain.Categoria;
import br.com.ecommerce.domain.Fornecedor;
import br.com.ecommerce.domain.Unidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    @Length(max = 300, message = "{prooduto.codbarras.length}")
    private String codBarras;

    @Length(max = 1000, message = "{produto.descricao.length}")
    private String descricao;

    @Length(max = 100, min = 5, message = "{produto.descricaoresumida.length}")
    private String descricaoResumida;

    @NotNull(message = "{produto.preco.not.null}")
    private double preco;

    private int quantidade;

    @NotNull(message = "{produto.vlipi.not.null}")
    private double vlIpi;

    @NotNull(message = "{produto.vlicms.not.null}")
    private double vlIcms;

    @NotNull(message = "{produto.vliss.not.null}")
    private double vlIss;

    @NotNull(message = "{produto.ncm.not.null}")
    private int ncm;

    @Length(max = 5, min = 1, message = "{produto.cfop.length}")
    private String cfop;

    private Blob foto;

    private Unidade unidade;

    private Categoria categoria;

    private Fornecedor fornecedor;
}