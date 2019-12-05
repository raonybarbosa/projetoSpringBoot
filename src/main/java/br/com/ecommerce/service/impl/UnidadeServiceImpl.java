package br.com.ecommerce.service.impl;

import br.com.ecommerce.domain.Unidade;
import br.com.ecommerce.domain.enuns.Status;
import br.com.ecommerce.exception.UnidadeNaoEncontradaException;
import br.com.ecommerce.repository.UnidadeRepository;
import br.com.ecommerce.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeServiceImpl implements UnidadeService {
    @Autowired
    UnidadeRepository unidadeRepository;

    @Override
    public Optional<List<Unidade>> listarUnidades() {
        return unidadeRepository.findByStatus(Status.A).
                map(Optional::of).orElseThrow(UnidadeNaoEncontradaException::new);
    }

    @Override
    public Unidade findByCodigo(Long codigo) {
        return unidadeRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .orElseThrow(UnidadeNaoEncontradaException::new);
    }

    @Override
    public Unidade alterarUnidade(Unidade unidade, Long codigo) {
        return unidadeRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .map(obj -> unidadeRepository.save(unidade))
                .orElseThrow(UnidadeNaoEncontradaException::new);
    }

    @Override
    public Unidade inserirUnidade(Unidade unidade) {
        unidade.setStatus(Status.A);
        return unidadeRepository.save(unidade);
    }

    @Override
    public String excluirPorCodigo(Long codigo) {
        Unidade unidade = findByCodigo(codigo);
        unidade.setStatus(Status.I);
        unidadeRepository.save(unidade);
        return "Registro Excluido com Sucesso";
    }

    @Override
    public String excluirUnidade(Unidade unidade) {
        unidadeRepository.delete(unidade);
        return "Registro Excluido com Sucesso";
    }

    @Override
    public Unidade findByDescricao(String descricao) {
        return unidadeRepository.findByDescricao(descricao);
    }
}
