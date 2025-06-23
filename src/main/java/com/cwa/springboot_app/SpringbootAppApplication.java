package com.cwa.springboot_app;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cwa.springboot_app.Enums.Regions;
import com.cwa.springboot_app.Enums.TypeDeServices;
import com.cwa.springboot_app.entity.Avis;
import com.cwa.springboot_app.entity.User;
import com.cwa.springboot_app.repository.AvisRepository;
import com.cwa.springboot_app.repository.UserRepository;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

	  @Bean
    CommandLineRunner runner(UserRepository utilisateurRepository, AvisRepository avisRepository, PasswordEncoder encoder) {
        return args -> {
            if (utilisateurRepository.findAll().isEmpty()) {
                User user = new User(null, "user", encoder.encode("pass"), "USER");
                User admin = new User(null, "admin", encoder.encode("admin"), "ADMIN");
                utilisateurRepository.saveAll(List.of(user, admin));

                avisRepository.save(new Avis(null, "Service hospitalier lent.", LocalDate.now(), TypeDeServices.HOPITAL,Regions.KOLDA ,user));
                avisRepository.save(new Avis(null, "Problèmes d'eau récurrents.", LocalDate.now(), TypeDeServices.SERVICE_DES_EAUX,Regions.ZIGUINCHOR, user));
            }
        };
    }
}

