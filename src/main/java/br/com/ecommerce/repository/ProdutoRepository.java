package br.com.ecommerce.repository;

import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.domain.enuns.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByDescricao(String descricao);

    Optional<List<Produto>> findByStatus(Status status);
}
