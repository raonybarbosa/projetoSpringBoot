package br.com.ecommerce.service;

import br.com.ecommerce.domain.Desconto;

import java.util.List;
import java.util.Optional;

public interface DescontoService {
    Optional<List<Desconto>> listarDescontos();

    Desconto findByCodigo(Long codigo);

    Desconto alterarDesconto(Desconto desconto, Long codigo);

    Desconto inserirDesconto(Desconto desconto);

    String excluirPorCodigo(Long codigo);

    String excluirDesconto(Desconto desconto);

    Desconto findByDescricao(String descricao);
}
