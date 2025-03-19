package com.abdala.demo;

import com.abdala.demo.entity.RegisterRequest;
import com.abdala.demo.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.UUID;

import static com.abdala.demo.user.Role.ADMIN;

@SpringBootApplication
@Configuration
@EntityScan
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service) {
        return args -> {
            String randomEmail;
            while (true) {
                randomEmail = generateRandomEmail();
                var admin = RegisterRequest.builder().firstname("Admin").lastname("Admin").email(randomEmail)
                        .password("password").role(ADMIN).build();
                try {
                    System.out.println("Admin token: " + service.register(admin).getRefreshToken());
                    break;
                } catch (DataIntegrityViolationException e) {
                    System.out.println("Duplicate email found: " + randomEmail + ", retrying...");
                }
            }
        };
    }

    private String generateRandomEmail() {
        return "user" + UUID.randomUUID() + "@example.com";
    }

    private String generateNewToken(AuthenticationService service, String email, String password) {
        var request = RegisterRequest.builder().email(email).password(password).build();
        return service.register(request).getRefreshToken();
    }
}