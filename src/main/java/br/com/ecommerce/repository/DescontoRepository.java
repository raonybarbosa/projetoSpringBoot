package br.com.ecommerce.repository;

import br.com.ecommerce.domain.Desconto;
import br.com.ecommerce.domain.enuns.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DescontoRepository extends JpaRepository<Desconto, Long> {
    Desconto findByDescricao(String descricao);

    Optional<List<Desconto>> findByStatus(Status status);
}
