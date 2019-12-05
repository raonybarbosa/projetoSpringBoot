package br.com.ecommerce.repository;

import br.com.ecommerce.domain.Fornecedor;
import br.com.ecommerce.domain.enuns.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Fornecedor findByNomeFantasia(String nomeFantasia);

    Optional<List<Fornecedor>> findByStatus(Status status);
}
