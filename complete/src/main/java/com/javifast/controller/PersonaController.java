package com.javifast.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javifast.model.Persona;
import com.javifast.services.PersonaService;

//@RestController
@Controller
public class PersonaController {


	
	@Autowired
	private PersonaService personaService;
	
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
	
	@RequestMapping(value= "/personas", method = RequestMethod.GET)
	public String list(Model modelo) {
		modelo.addAttribute("personas", personaService.listaPersona());
		return "personas";
	}
	
	@RequestMapping(value= "/persona/{id}")
	public String mostrarPersona(@PathVariable Integer id,Model modelo) {
		modelo.addAttribute("persona", personaService.getPersonaId(id));
		return "mostrarPersona";
	}
	
	@RequestMapping(value= "/persona/editar/{id}")
	public String editar(@PathVariable Integer id,Model modelo) {
		modelo.addAttribute("persona", personaService.getPersonaId(id));
		return "personaFormulario";
	}
	
	@RequestMapping(value= "/persona/nuevo")
	public String nuevaPersona(Model modelo) {
		modelo.addAttribute("persona", new Persona(0, null, null));
		return "personaFormulario";
	}
	
	@RequestMapping(value= "/persona", method = RequestMethod.POST)
	public String savePersona(Persona persona) {
		personaService.savePersona(persona);
		return "redirect:/personas/";
	}
	
	@RequestMapping(value= "/persona/borrar/{id}")
	public String delete(@PathVariable Integer id) {
		personaService.deletPersona(id);
		return "redirect:/personas/";
	}
}
