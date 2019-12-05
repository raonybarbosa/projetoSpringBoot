package br.com.ecommerce.service.impl;

import br.com.ecommerce.domain.Categoria;
import br.com.ecommerce.domain.enuns.Status;
import br.com.ecommerce.exception.CategoriaNaoEncontradaException;
import br.com.ecommerce.repository.CategoriaRepository;
import br.com.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Optional<List<Categoria>> listarCategorias() {
        return categoriaRepository.findByStatus(Status.A).
                map(Optional::of).orElseThrow(CategoriaNaoEncontradaException::new);
    }

    public Categoria findByCodigo(Long codigo) {
        return categoriaRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .orElseThrow(CategoriaNaoEncontradaException::new);
    }

    public Categoria alterarCategoria(Categoria categoria, Long codigo) {
        return categoriaRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .map(obj -> categoriaRepository.save(categoria))
                .orElseThrow(CategoriaNaoEncontradaException::new);
    }

    public Categoria inserirCategoria(Categoria categoria) {
        categoria.setStatus(Status.A);
        return categoriaRepository.save(categoria);
    }

    public String excluirPorCodigo(Long codigo) {
        Categoria categoria = findByCodigo(codigo);
        categoria.setStatus(Status.I);
        categoriaRepository.save(categoria);
        return "Registro excluído com sucesso.";
    }

    public String excluirCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
        return "Registro excluído com sucesso.";
    }

    /*public Categoria findByDescricao(String descricao) {
        return categoriaRepository.findByDescricao(descricao);
    }*/
}