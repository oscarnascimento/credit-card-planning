package br.com.oscarnascimento.creditcardplanning.model.dto;

import lombok.Data;

@Data
public class TokenDto {

    private String accessToken;
    private String type;

    public TokenDto(String accessToken, String type) {
        this.accessToken = accessToken;
        this.type = type;
    }
}
