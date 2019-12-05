package br.com.ecommerce.repository;

import br.com.ecommerce.domain.Unidade;
import br.com.ecommerce.domain.enuns.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
    Unidade findByDescricao(String descricao);

    Optional<List<Unidade>> findByStatus(Status status);
}
