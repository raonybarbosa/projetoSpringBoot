package br.com.ecommerce.domain.dto;

import br.com.ecommerce.domain.enuns.EnumSN;
import br.com.ecommerce.domain.enuns.TipoFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {

    @Length(min = 3, max = 300, message = "{fornecedor.nome.length}")
    private String nome;

    @Length(min = 3, max = 300, message = "{fornecedor.nomefantasia.length}")
    private String nomeFantasia;

    @Length(min = 1, max = 1, message = "{fornecedor.tipofornecedor.length}")
    private TipoFornecedor tipoFornecedor;

    @Length(max = 14, message = "{fornecedor.cnpj.length}")
    private String cnpj;

    @Length(max = 11, message = "{fornecedor.cpf.length}")
    private String cpf;

    @Length(min = 10, max = 20, message = "{fornecedor.telefone.length}")
    private long telefone;

    @Length(min = 10, max = 100, message = "{fornecedor.email.length}")
    private String email;

    @Length(min = 8, max = 8, message = "{fornecedor.cep.length}")
    private int cep;

    @Length(min = 9, max = 150, message = "{fornecedor.endereco.length}")
    private String endereco;

    @Length(max = 200, message = "{fornecedor.complemento.length}")
    private String complemento;

    @Length(min = 1, max = 50, message = "{fornecedor.numero.length}")
    private String numero;

    @Length(min = 3, max = 50, message = "{fornecedor.bairro.length}")
    private String bairro;

    @Length(min = 3, max = 50, message = "{fornecedor.cidade.length}")
    private String cidade;

    @Length(min = 2, max = 20, message = "{fornecedor.estado.length}")
    private String estado;

    @Length(min = 2, max = 20, message = "{fornecedor.pais.length}")
    private String pais;

    @Length(min = 1, max = 1, message = "{fornecedor.simplesnacional.length}")
    private EnumSN simplesNacional;

    @NotBlank(message = "{fornecedor.inscrmunicipal.not.blank}")
    private long inscrMunicipal;

    @NotBlank(message = "{fornecedor.inscrestadual.not.blank}")
    private long inscrEstadual;
}
