package br.com.oscarnascimento.creditcardplanning.config.security;

import br.com.oscarnascimento.creditcardplanning.model.entity.User;
import br.com.oscarnascimento.creditcardplanning.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class AuthenticationViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserService userService;

    public AuthenticationViaTokenFilter(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = retrieveToken(request);

        Boolean isTokenValid = tokenService.isTokenValid(token);

        if (isTokenValid)
            authenticateClient(token);

        filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        Long idUser = tokenService.getUserId(token);
        User user = userService.findById(idUser);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getRoles());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (Objects.isNull(token) || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }

}
