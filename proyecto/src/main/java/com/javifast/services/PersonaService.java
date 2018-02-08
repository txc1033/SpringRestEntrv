package com.javifast.services;

import com.javifast.model.Persona;

public interface PersonaService {
 Iterable<Persona> AllPersona();
 Persona getPersonaId(Integer id);
 Persona savePersona(Persona persona);
 void deletPersona(Integer id);
}
