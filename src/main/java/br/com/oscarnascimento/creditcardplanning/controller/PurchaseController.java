package br.com.oscarnascimento.creditcardplanning.controller;

import br.com.oscarnascimento.creditcardplanning.model.dto.CreditCardDto;
import br.com.oscarnascimento.creditcardplanning.model.dto.PurchaseDto;
import br.com.oscarnascimento.creditcardplanning.model.entity.CreditCard;
import br.com.oscarnascimento.creditcardplanning.service.CreditCardService;
import br.com.oscarnascimento.creditcardplanning.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseController {

    private final PurchaseService service;

    @Autowired
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<PurchaseDto>> list() {
       List<PurchaseDto> response = service.list();
       return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<PurchaseDto> create(@RequestBody PurchaseDto purchaseDto) {
        PurchaseDto response = service.create(purchaseDto);
        return ResponseEntity.ok(response);
    }

}
