package org.example.bookstoremain;

import org.example.bookstoremain.model.User;
import org.example.bookstoremain.repository.UserRepository;
import org.example.bookstoremain.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceTest {
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserService userService = new UserService(userRepository, passwordEncoder);

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        userService.registerUser(user);

        Mockito.verify(userRepository).save(Mockito.any(User.class));

        Mockito.verify(userRepository).save(Mockito.argThat(u ->
                u.getPassword() != null && !u.getPassword().equals("password")
        ));
    }
}
