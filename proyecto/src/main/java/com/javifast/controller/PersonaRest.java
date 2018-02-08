package com.javifast.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.javifast.model.Persona;
import com.javifast.services.PersonaService;

@RestController
public class PersonaRest {


	@Autowired
	private PersonaService personaService;
	
    @RequestMapping(value = "/personas", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> getAllPersona() {
		List<Persona> list = (List<Persona>) personaService.AllPersona();
		return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/personas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Persona> getPersonaId(@PathVariable("id") Integer id) {
    	Persona persona = personaService.getPersonaId(id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/personas", method = RequestMethod.POST)
    public ResponseEntity<Void> addPersona(@RequestBody Persona persona, UriComponentsBuilder builder) {
    	try {
        personaService.savePersona(persona);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/personas/{id}").buildAndExpand(persona.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    	}catch(ConstraintViolationException e) {
    		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	}
    }
    
    @RequestMapping(value = "/personas", method = RequestMethod.PUT)
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
		personaService.savePersona(persona);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletPersona(@PathVariable("id") Integer id) {
		personaService.deletPersona(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}
