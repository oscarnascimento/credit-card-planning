package br.com.oscarnascimento.creditcardplanning.controller;

import br.com.oscarnascimento.creditcardplanning.model.entity.CreditCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/creditcards")
public class CreditCardController {

    @GetMapping
    public ResponseEntity<List<CreditCard>> list() {

       var creditCard = CreditCard.builder().description("Primeiro Cartão").build();

       return ResponseEntity.ok(List.of(creditCard));
    }

}
