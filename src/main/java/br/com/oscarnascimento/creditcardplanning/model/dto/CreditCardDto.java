package br.com.oscarnascimento.creditcardplanning.model.dto;

import br.com.oscarnascimento.creditcardplanning.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

    private Long id;

    private String description;

    private String lastNumbers;

    private User user;
}
