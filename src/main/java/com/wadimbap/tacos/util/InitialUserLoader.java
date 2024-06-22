package com.wadimbap.tacos.util;

import com.wadimbap.tacos.model.User;
import com.wadimbap.tacos.model.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitialUserLoader {

    @Bean
    public ApplicationRunner dataLoad(UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            userRepo.save(new User("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
            userRepo.save(new User("habuma", encoder.encode("password"), "ROLE_ADMIN"));
        };
    }
}
