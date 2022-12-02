package br.com.oscarnascimento.creditcardplanning.repository;

import br.com.oscarnascimento.creditcardplanning.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
