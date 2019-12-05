package br.com.ecommerce.service.impl;

import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.domain.enuns.Status;
import br.com.ecommerce.exception.ProdutoNaoEncontradoException;
import br.com.ecommerce.repository.ProdutoRepository;
import br.com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Optional<List<Produto>> listarProdutos() {
        return produtoRepository.findByStatus(Status.A).map(Optional::of).orElseThrow(ProdutoNaoEncontradoException::new);
    }

    public Produto findByCodigo(Long codigo) {
        return produtoRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .orElseThrow(ProdutoNaoEncontradoException::new);
    }

    public Produto alterarProduto(Produto produto, Long codigo) {
        return produtoRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .map(obj -> produtoRepository.save(produto))
                .orElseThrow(ProdutoNaoEncontradoException::new);
    }

    public Produto inserirProduto(Produto produto) {
        produto.setStatus(Status.A);
        return produtoRepository.save(produto);
    }

    public String excluirPorCodigo(Long codigo) {
        Produto produto = findByCodigo(codigo);
        produto.setStatus(Status.I);
        produtoRepository.save(produto);
        return "Registro excluído com sucesso.";
    }

    public String excluirProduto(Produto produto) {
        produtoRepository.delete(produto);
        return "Registro Excluido com Sucesso";
    }

    @Override
    public Produto findByDescricao(String descricao) {
        return produtoRepository.findByDescricao(descricao);
    }
}
