package com.javifast.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.javifast.model.Persona;

@Transactional
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
