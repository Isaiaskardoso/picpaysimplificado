package com.ex.picpaysimplificado.repositories;

import com.ex.picpaysimplificado.domain.user.User;
import com.ex.picpaysimplificado.domain.user.UserType;
import com.ex.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager entityManager;
    @Test
    @DisplayName("Should get User successfully from DB")
    void findUserByDocumentCase1() { //args
        String document = "99999999902";
        UserDTO data = new UserDTO("Isaias", "Teste", document,
                "test@gmail.com", "4444",new BigDecimal(10), UserType.COMMON);
        this.createUser(data);

        Optional<User> result = this.userRepository.findUserByDocument(document);

        assertThat(result.isPresent()).isTrue();

    }
    @Test
    @DisplayName("Should not get User from DB when user not exists")
    void findUserByDocumentCase2() { //args
        String document = "99999999902";


        Optional<User> result = this.userRepository.findUserByDocument(document);

        assertThat(result.isEmpty()).isTrue();

    }
    private User createUser(UserDTO data){
        User newUser = new User(data);
        this.entityManager.persist(newUser);
        return newUser;
    }
}