package br.com.oscarnascimento.creditcardplanning.service;

import br.com.oscarnascimento.creditcardplanning.model.dto.PurchaseDto;
import br.com.oscarnascimento.creditcardplanning.model.entity.CreditCard;
import br.com.oscarnascimento.creditcardplanning.model.entity.Purchase;
import br.com.oscarnascimento.creditcardplanning.repository.CreditCardRepository;
import br.com.oscarnascimento.creditcardplanning.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    private final PurchaseRepository repository;
    private final CreditCardRepository creditCardRepository;


    @Autowired
    public PurchaseService(PurchaseRepository repository, CreditCardRepository creditCardRepository) {
        this.repository = repository;
        this.creditCardRepository = creditCardRepository;
    }

    public List<PurchaseDto> list() {
        return repository.findAll().stream().map(entity ->
            PurchaseDto.builder()
                    .id(entity.getId())
                    .description(entity.getDescription())
                    .amount(entity.getAmount())
                    .purchaseDate(entity.getPurchaseDate())
                    .installmentsQuantity(entity.getInstallmentsQuantity())
                    .invoiceFirstPaymentDate(entity.getInvoiceFirstPaymentDate())
                    .creditCard(entity.getCreditCard())
                    .build()
        ).collect(Collectors.toList());
    }

    public PurchaseDto create(PurchaseDto dto) {

        CreditCard creditCard = creditCardRepository.findById(dto.getCreditCard().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit Card Not Found"));

        Purchase newEntity = Purchase.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .purchaseDate(dto.getPurchaseDate())
                .installmentsQuantity(dto.getInstallmentsQuantity())
                .invoiceFirstPaymentDate(dto.getInvoiceFirstPaymentDate())
                .creditCard(creditCard)
                .build();

        Purchase savedEntity = repository.save(newEntity);

        return PurchaseDto.builder()
                .id(savedEntity.getId())
                .description(savedEntity.getDescription())
                .amount(savedEntity.getAmount())
                .purchaseDate(savedEntity.getPurchaseDate())
                .installmentsQuantity(savedEntity.getInstallmentsQuantity())
                .invoiceFirstPaymentDate(savedEntity.getInvoiceFirstPaymentDate())
                .creditCard(savedEntity.getCreditCard())
                .build();
    }
}
