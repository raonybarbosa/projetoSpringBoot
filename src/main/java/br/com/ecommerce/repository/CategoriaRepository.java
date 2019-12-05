package br.com.ecommerce.repository;

import br.com.ecommerce.domain.Categoria;
import br.com.ecommerce.domain.enuns.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByDescricaoAndStatus(String descricao, String status);

    Optional<List<Categoria>> findByStatus(Status status);

}
