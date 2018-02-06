package com.javifast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javifast.model.Persona;

@RestController
public class PersonaRest {


    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public Persona persona(@RequestParam(value="id", defaultValue="23") Integer id,
    					   @RequestParam(value="nombre", defaultValue="JavierMS") String nombre,
    					   @RequestParam(value="apellido", defaultValue="Txc1033") String apellido) {
        return new Persona(id,nombre,apellido);
    }
    
    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public Persona persona1(@RequestParam(value="id", defaultValue="23") Integer id,
    					   @RequestParam(value="nombre", defaultValue="JavierMS") String nombre,
    					   @RequestParam(value="apellido", defaultValue="Txc1033") String apellido) {
        return new Persona(id,nombre,apellido);
    }
    
    @RequestMapping(value = "/rest", method = RequestMethod.PUT)
    public Persona persona2(@RequestParam(value="id", defaultValue="23") Integer id,
    					   @RequestParam(value="nombre", defaultValue="JavierMS") String nombre,
    					   @RequestParam(value="apellido", defaultValue="Txc1033") String apellido) {
        return new Persona(id,nombre,apellido);
    }
    
    @RequestMapping(value = "/rest", method = RequestMethod.DELETE)
    public Persona persona3(@RequestParam(value="id", defaultValue="23") Integer id,
    					   @RequestParam(value="nombre", defaultValue="JavierMS") String nombre,
    					   @RequestParam(value="apellido", defaultValue="Txc1033") String apellido) {
        return new Persona(id,nombre,apellido);
    }
	
}
