package br.com.ecommerce.service;

import br.com.ecommerce.domain.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Optional<List<Categoria>> listarCategorias();

    Categoria findByCodigo(Long codigo);

    Categoria alterarCategoria(Categoria categoria, Long codigo);

    Categoria inserirCategoria(Categoria categoria);

    String excluirPorCodigo(Long codigo);

    String excluirCategoria(Categoria categoria);

    //Categoria findByDescricao(String descricao);
}
