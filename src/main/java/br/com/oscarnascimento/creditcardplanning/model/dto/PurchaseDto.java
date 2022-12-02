package br.com.oscarnascimento.creditcardplanning.model.dto;

import br.com.oscarnascimento.creditcardplanning.model.entity.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {

    private Long id;

    private String description;

    private BigDecimal amount;

    private Long installmentsQuantity;

    private LocalDate purchaseDate;

    private LocalDate invoiceFirstPaymentDate;

    private CreditCard creditCard;
}
