package com.javifast.controller;

import java.util.List;

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
	
    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> llamarAllPersona() {
		List<Persona> list = (List<Persona>) personaService.listaPersona();
		return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/{id}", method = RequestMethod.GET)
    public ResponseEntity<Persona> llamarPersona(@PathVariable("id") Integer id) {
    	Persona persona = personaService.getPersonaId(id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public ResponseEntity<Void> agregarPersona(@RequestBody Persona persona, UriComponentsBuilder builder) {
        boolean flag = personaService.savePersona(persona) != null;
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(persona.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/rest", method = RequestMethod.PUT)
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona) {
		personaService.savePersona(persona);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarPersona(@PathVariable("id") Integer id) {
		personaService.deletPersona(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}
