package br.com.oscarnascimento.creditcardplanning.controller;

import br.com.oscarnascimento.creditcardplanning.config.security.TokenService;
import br.com.oscarnascimento.creditcardplanning.model.dto.LoginForm;
import br.com.oscarnascimento.creditcardplanning.model.dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {

        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenDto> auth(@RequestBody @Valid LoginForm loginForm) {

        try {
            Authentication authentication = authenticationManager.authenticate(loginForm.convertToAuth());
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
