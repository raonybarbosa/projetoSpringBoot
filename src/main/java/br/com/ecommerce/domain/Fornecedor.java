package br.com.ecommerce.domain;

import br.com.ecommerce.domain.enuns.EnumSN;
import br.com.ecommerce.domain.enuns.Status;
import br.com.ecommerce.domain.enuns.TipoFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(name = "nome", length = 300, nullable = false)
    private String nome;

    @Column(name = "nomeFantasia", length = 300, nullable = false)
    private String nomeFantasia;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoFornecedor", length = 1, nullable = false)
    private TipoFornecedor tipoFornecedor;

    @Column(name = "cnpj", length = 14, nullable = true)
    @CNPJ
    private String cnpj;

    @Column(name = "cpf", length = 11, nullable = true)
    @CPF
    private String cpf;

    @Column(name = "telefone", length = 20, nullable = false)
    private long telefone;

    @Column(name = "email", length = 100, nullable = false)
    @Email
    private String email;

    @Column(name = "cep", length = 8, nullable = false)
    private int cep;

    @Column(name = "endereco", length = 150, nullable = false)
    private String endereco;

    @Column(name = "complemento", length = 200, nullable = true)
    private String complemento;

    @Column(name = "numero", length = 50, nullable = false)
    private String numero;

    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "pais", length = 20, nullable = false)
    private String pais;

    @Enumerated(EnumType.STRING)
    @Column(name = "simplesNacional", length = 1, nullable = false)
    private EnumSN simplesNacional;

    @Column(name = "inscrMunicipal", nullable = false)
    private long inscrMunicipal;

    @Column(name = "inscrEstadual", nullable = false)
    private long inscrEstadual;

    @Column(name = "usuarioCadastro", length = 100, nullable = false)
    private String usuarioCadastro;

    @Column(name = "usuarioAlteracao", length = 100, nullable = true)
    private String usuarioAlteracao;

    @Column(name = "dtCadastro", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtCadastro;

    @Column(name = "dtAlteracao", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtAlteracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 1, nullable = false)
    private Status status;
}