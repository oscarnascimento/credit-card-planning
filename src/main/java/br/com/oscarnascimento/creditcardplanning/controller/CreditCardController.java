package br.com.oscarnascimento.creditcardplanning.controller;

import br.com.oscarnascimento.creditcardplanning.model.dto.CreditCardDto;
import br.com.oscarnascimento.creditcardplanning.model.entity.CreditCard;
import br.com.oscarnascimento.creditcardplanning.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/v1/creditcards")
public class CreditCardController {

    private final CreditCardService service;

    @Autowired
    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CreditCardDto>> list() {
       List<CreditCardDto> response = service.list();
       return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CreditCardDto> create(@RequestBody CreditCardDto creditCard) {
        CreditCardDto response = service.create(creditCard);
        return ResponseEntity.ok(response);
    }

}
