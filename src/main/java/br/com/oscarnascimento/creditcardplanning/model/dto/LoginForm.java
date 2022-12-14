package br.com.oscarnascimento.creditcardplanning.model.dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public UsernamePasswordAuthenticationToken convertToAuth() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
