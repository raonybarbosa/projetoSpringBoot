package br.com.ecommerce.service;

import br.com.ecommerce.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    Optional<List<Produto>> listarProdutos();

    Produto findByCodigo(Long codigo);

    Produto alterarProduto(Produto produto, Long codigo);

    Produto inserirProduto(Produto produto);

    String excluirPorCodigo(Long codigo);

    String excluirProduto(Produto produto);

    Produto findByDescricao(String descricao);
}
