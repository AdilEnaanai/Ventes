package univ.fac.gcommerce.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import univ.fac.gcommerce.entities.User;
import univ.fac.gcommerce.repositories.UserRepository;

@RestController
public class signup {
    final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public signup(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
    String cryptedPassword=passwordEncoder.encode(user.getPassword());
    user.setPassword(cryptedPassword);
    return userRepository.save(user);
    }
}
