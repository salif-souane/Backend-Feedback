package com.cwa.springboot_app.controller;


import com.cwa.springboot_app.Enums.TypeDeServices;
import com.cwa.springboot_app.entity.*;
import com.cwa.springboot_app.repository.AvisRepository;
import com.cwa.springboot_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedbackController {

    private final AvisRepository avisRepository;
    private final UserRepository useRepository;

    // USER : Poster un avis
    @PostMapping("/avis")
    @PreAuthorize("hasRole('USER')")
    public Avis ajouterAvis(@RequestBody Avis avis, Authentication authentication) {
     //   User user = utilisateurRepository.findByUsername(authentication.getUsername());
    //    avis.setUser(user);
        avis.setDate(LocalDate.now());
        return avisRepository.save(avis);
    }

    // Public : Lire les avis par type
    @GetMapping("/avis/{typeService}")
    public List<Avis> getAvisParService(@PathVariable TypeDeServices typeService) {
        return avisRepository.findByTypeService(typeService);
    }

    // ADMIN : Lire tous les avis
    @GetMapping("/admin/avis")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Avis> getTousLesAvis() {
        return avisRepository.findAll();
    }

    // ADMIN : Supprimer un avis
    @DeleteMapping("/admin/avis/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void supprimerAvis(@PathVariable Long id) {
        avisRepository.deleteById(id);
    }
}
