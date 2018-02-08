package com.javifast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javifast.model.Persona;
import com.javifast.repository.PersonaRepository;

@Service
public class PersonaSericeImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Iterable<Persona> AllPersona() {
		return personaRepository.findAll();
	}

	@Override
	public Persona getPersonaId(Integer id) {
		return personaRepository.findOne(id);
	}

	@Override
	public Persona savePersona(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void deletPersona(Integer id) {
		personaRepository.delete(id);
		
	}

	
}
