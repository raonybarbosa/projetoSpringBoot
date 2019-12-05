package br.com.ecommerce.domain;

import br.com.ecommerce.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(name = "codBarras", length = 300, nullable = true)
    private String codBarras;

    @Column(name = "descricao", length = 1000, nullable = true)
    private String descricao;

    @Column(name = "descricaoResumida", length = 100, nullable = false)
    private String descricaoResumida;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "quantidade", nullable = true)
    private int quantidade;

    @Column(name = "vlIpi", nullable = false)
    private double vlIpi;

    @Column(name = "vlIcms", nullable = false)
    private double vlIcms;

    @Column(name = "vlIss", nullable = false)
    private double vlIss;

    @Column(name = "ncm", nullable = false)
    private int ncm;

    @Column(name = "cfop", length = 5, nullable = false)
    private String cfop;

    @Column(name = "dtCadastro", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtCadastro;

    @Column(name = "dtAlteracao", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtAlteracao;

    @Column(name = "vlCustoMedio", nullable = true)
    private double vlCustoMedio;

    @Column(name = "usuarioCadastro", length = 100, nullable = false)
    private String usuarioCadastro;

    @Column(name = "usuarioAlteracao", length = 100, nullable = true)
    private String usuarioAlteracao;

    @Column(name = "foto", nullable = true)
    private Blob foto;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 1, nullable = false)
    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    private Unidade unidade;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    private Categoria categoria;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany
    private List<Fornecedor> fornecedor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany
    private List<Desconto> descontos;
}