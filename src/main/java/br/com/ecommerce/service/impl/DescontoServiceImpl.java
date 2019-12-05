package br.com.ecommerce.service.impl;

import br.com.ecommerce.domain.Desconto;
import br.com.ecommerce.domain.enuns.Status;
import br.com.ecommerce.exception.DescontoNaoEncontradoException;
import br.com.ecommerce.repository.DescontoRepository;
import br.com.ecommerce.service.DescontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescontoServiceImpl implements DescontoService {

    @Autowired
    DescontoRepository descontoRepository;

    @Override
    public Optional<List<Desconto>> listarDescontos() {
        return descontoRepository.findByStatus(Status.A).map(Optional::of).orElseThrow(DescontoNaoEncontradoException::new);
    }

    @Override
    public Desconto findByCodigo(Long codigo) {
        return descontoRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .orElseThrow(DescontoNaoEncontradoException::new);
    }

    @Override
    public Desconto alterarDesconto(Desconto desconto, Long codigo) {
        return descontoRepository.findById(codigo)
                .filter(x -> x.getStatus().equals(Status.A))
                .map(obj -> descontoRepository.save(desconto))
                .orElseThrow(DescontoNaoEncontradoException::new);
    }

    @Override
    public Desconto inserirDesconto(Desconto desconto) {
        desconto.setStatus(Status.A);
        return descontoRepository.save(desconto);
    }

    @Override
    public String excluirPorCodigo(Long codigo) {
        Desconto desconto = findByCodigo(codigo);
        desconto.setStatus(Status.I);
        descontoRepository.save(desconto);
        return "Registro excluído com sucesso.";
    }

    @Override
    public String excluirDesconto(Desconto desconto) {
        descontoRepository.delete(desconto);
        return "Registro Excluido com Sucesso";
    }

    @Override
    public Desconto findByDescricao(String descricao) {
        return descontoRepository.findByDescricao(descricao);
    }
}
