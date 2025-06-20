package com.cwa.springboot_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwa.springboot_app.entity.Avis;
import com.cwa.springboot_app.Enums.TypeDeServices;

public interface AvisRepository extends JpaRepository<Avis, Long> {
    List<Avis> findByTypeService(TypeDeServices typeService);
}
