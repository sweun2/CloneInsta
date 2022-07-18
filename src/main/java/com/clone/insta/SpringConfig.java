package com.clone.insta;

import com.clone.insta.repository.UserRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;

    public SpringConfig() {
    }
}
