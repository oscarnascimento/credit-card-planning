package br.com.oscarnascimento.creditcardplanning.service;

import br.com.oscarnascimento.creditcardplanning.model.dto.CreditCardDto;
import br.com.oscarnascimento.creditcardplanning.model.entity.CreditCard;
import br.com.oscarnascimento.creditcardplanning.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardService {

    private final CreditCardRepository repository;
    private final UserService userService;

    @Autowired
    public CreditCardService(CreditCardRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public List<CreditCardDto> list() {
        return repository.findAll().stream()
                .map(entity -> CreditCardDto.builder()
                                .id(entity.getId())
                                .lastNumbers(entity.getLastNumbers())
                                .user(entity.getUser()).build())
                .collect(Collectors.toList());
    }

    public CreditCardDto create(CreditCardDto creditCardDto) {

        br.com.oscarnascimento.creditcardplanning.model.entity.User user = userService.findById(creditCardDto.getUser().getId());

        CreditCard creditCard = CreditCard.builder()
                .description(creditCardDto.getDescription())
                .lastNumbers(creditCardDto.getLastNumbers())
                .user(user)
                .build();

        CreditCard creditCardSaved = repository.save(creditCard);

        return CreditCardDto.builder()
                .description(creditCardSaved.getDescription())
                .lastNumbers(creditCardDto.getLastNumbers())
                .user(creditCardDto.getUser())
                .id(creditCardSaved.getId()).build();
    }
}
