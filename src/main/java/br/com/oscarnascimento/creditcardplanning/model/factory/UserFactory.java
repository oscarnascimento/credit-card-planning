package br.com.oscarnascimento.creditcardplanning.model.factory;

import br.com.oscarnascimento.creditcardplanning.model.dto.SignupDto;
import br.com.oscarnascimento.creditcardplanning.model.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class UserFactory {

    public static User signupDtoToEntity(SignupDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(dto, User.class);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return user;
    }

    public static SignupDto entityToSignupDto(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, SignupDto.class);
    }

}
