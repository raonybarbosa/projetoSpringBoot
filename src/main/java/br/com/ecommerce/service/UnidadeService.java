package br.com.ecommerce.service;

import br.com.ecommerce.domain.Unidade;

import java.util.List;
import java.util.Optional;

public interface UnidadeService {
    Optional<List<Unidade>> listarUnidades();

    Unidade findByCodigo(Long codigo);

    Unidade alterarUnidade(Unidade unidade, Long codigo);

    Unidade inserirUnidade(Unidade unidade);

    String excluirPorCodigo(Long codigo);

    String excluirUnidade(Unidade unidade);

    Unidade findByDescricao(String descricao);
}
