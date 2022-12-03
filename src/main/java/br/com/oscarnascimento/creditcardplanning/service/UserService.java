package br.com.oscarnascimento.creditcardplanning.service;

import br.com.oscarnascimento.creditcardplanning.model.dto.SignupDto;
import br.com.oscarnascimento.creditcardplanning.model.entity.User;
import br.com.oscarnascimento.creditcardplanning.model.factory.UserFactory;
import br.com.oscarnascimento.creditcardplanning.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found or data invalid."));
    }

    public SignupDto signup(SignupDto signupDto) {
        User user = UserFactory.signupDtoToEntity(signupDto);
        User saved = repository.save(user);
        return UserFactory.entityToSignupDto(saved);
    }
}
