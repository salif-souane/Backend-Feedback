package com.cwa.springboot_app.entity;



import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.cwa.springboot_app.Enums.TypeDeServices;
import com.cwa.springboot_app.Enums.Regions;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AVIS")
public class Avis {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TypeDeServices typeService;

    @Enumerated(EnumType.STRING)
    private com.cwa.springboot_app.Enums.Regions regions;

    @ManyToOne
    private User utilisateur;
}
