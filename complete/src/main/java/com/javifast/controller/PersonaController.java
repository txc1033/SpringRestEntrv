package com.javifast.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public Model list(Model modelo) {
		modelo.addAttribute("persona", personaService.listaPersona());
		return modelo;
	}
	
	@RequestMapping(value= "/persona/{id}")
	public String mostrarPersona(@PathVariable Integer id,Model modelo) {
		modelo.addAttribute("persona", personaService.getPersonaId(id));
		return "persona";
	}
	
	@RequestMapping(value= "/persona/editar/{id}")
	public String editar(@PathVariable Integer id,Model modelo) {
		modelo.addAttribute("persona", personaService.getPersonaId(id));
		return "formulario";
	}
	
	@RequestMapping(value= "/persona/nuevo")
	public String nuevaPersona(Model modelo) {
		modelo.addAttribute("persona", new Persona(0, null, null));
		return "formulario";
	}
	
	@RequestMapping(value= "/persona", method = RequestMethod.POST)
	public String savePersona(Persona persona) {
		personaService.savePersona(persona);
		return "redirect:/persona/";
	}
	
	@RequestMapping(value= "/persona/borrar/{id}")
	public String delete(@PathVariable Integer id) {
		personaService.deletPersona(id);
		return "redirect:/persona/";
	}
}
