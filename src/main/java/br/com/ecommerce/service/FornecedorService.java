package br.com.ecommerce.service;

import br.com.ecommerce.domain.Fornecedor;

import java.util.List;
import java.util.Optional;

public interface FornecedorService {
    Optional<List<Fornecedor>> listarFornecedores();

    Fornecedor findByCodigo(Long codigo);

    Fornecedor alterarFornecedor(Fornecedor fornecedor, Long codigo);

    Fornecedor inserirFornecedor(Fornecedor fornecedor);

    String excluirPorCodigo(Long codigo);

    String excluirFornecedor(Fornecedor fornecedor);

    Fornecedor findByNomeFantasia(String nomeFantasia);
}