package br.com.oscarnascimento.creditcardplanning.repository;

import br.com.oscarnascimento.creditcardplanning.model.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
