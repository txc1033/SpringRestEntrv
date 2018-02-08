package com.javifast.controller;



import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javifast.model.Persona;
import com.javifast.services.PersonaService;


@Controller
public class PersonaController {

	
	@Autowired
	private PersonaService personaService;
	
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
	
	@RequestMapping(value= "/persona", method = RequestMethod.GET)
	public Model showAllPersona(Model modelo) {
		modelo.addAttribute("persona", personaService.AllPersona());
		return modelo;
	}
	
	@RequestMapping(value= "/persona/{id}")
	public String showPersona(@PathVariable Integer id,Model modelo) {
		modelo.addAttribute("persona", personaService.getPersonaId(id));
		return "persona";
	}
	
	@RequestMapping(value= "/persona/editar/{id}")
	public String editPersona(@PathVariable Integer id,Model modelo) {
		modelo.addAttribute("persona", personaService.getPersonaId(id));
		return "formulario";
	}
	
	@RequestMapping(value= "/persona/nuevo")
	public String newPersona(Model modelo) {
		int id = 0;String nombre="",apellido="";
		Persona p = new Persona(id,nombre,apellido);
		modelo.addAttribute("persona",p);
		return "formulario";
	}
	
	@RequestMapping(value= "/persona", method = RequestMethod.POST)
	public String savePersona(Persona persona) {
		try {
		personaService.savePersona(persona);
		return "redirect:/persona/";
		}catch(ConstraintViolationException e) {
			return "redirect:/persona/nuevo";
		}
	}
	
	@RequestMapping(value= "/persona/borrar/{id}")
	public String delete(@PathVariable Integer id) {
		personaService.deletPersona(id);
		return "redirect:/persona/";
	}
}
