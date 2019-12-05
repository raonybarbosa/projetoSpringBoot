package br.com.ecommerce.service.impl;

import br.com.ecommerce.domain.Fornecedor;
import br.com.ecommerce.domain.enuns.Status;
import br.com.ecommerce.exception.FornecedorNaoEncontradoException;
import br.com.ecommerce.repository.FornecedorRepository;
import br.com.ecommerce.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public Optional<List<Fornecedor>> listarFornecedores() {
        return fornecedorRepository.findByStatus(Status.A).map(Optional::of).orElseThrow(FornecedorNaoEncontradoException::new);
    }

    @Override
    public Fornecedor findByCodigo(Long codigo) {
        return fornecedorRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .orElseThrow(FornecedorNaoEncontradoException::new);
    }

    @Override
    public Fornecedor alterarFornecedor(Fornecedor fornecedor, Long codigo) {
        return fornecedorRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .map(obj -> fornecedorRepository.save(fornecedor))
                .orElseThrow(FornecedorNaoEncontradoException::new);
    }

    @Override
    public Fornecedor inserirFornecedor(Fornecedor fornecedor) {
        fornecedor.setStatus(Status.A);
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public String excluirPorCodigo(Long codigo) {
        Fornecedor fornecedor = findByCodigo(codigo);
        fornecedor.setStatus(Status.I);
        fornecedorRepository.save(fornecedor);
        return "Registro excluído com sucesso.";
    }

    @Override
    public String excluirFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.delete(fornecedor);
        return "Registro Excluido com Sucesso";
    }

    @Override
    public Fornecedor findByNomeFantasia(String nomeFantasia) {
        return fornecedorRepository.findByNomeFantasia(nomeFantasia);
    }
}
