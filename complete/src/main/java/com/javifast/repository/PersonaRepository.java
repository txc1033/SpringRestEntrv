package com.javifast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javifast.model.Persona;



@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
