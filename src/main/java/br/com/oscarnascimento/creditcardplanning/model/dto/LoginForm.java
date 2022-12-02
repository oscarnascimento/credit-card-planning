package br.com.oscarnascimento.creditcardplanning.model.dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginForm {
    private String username;
    private String password;

    public UsernamePasswordAuthenticationToken convertToAuth() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
