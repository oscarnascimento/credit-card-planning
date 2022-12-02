package br.com.oscarnascimento.creditcardplanning.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "installments_quantity")
    private Long installmentsQuantity;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "invoice_first_payment_month")
    private LocalDate invoiceFirstPaymentDate;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;
}
