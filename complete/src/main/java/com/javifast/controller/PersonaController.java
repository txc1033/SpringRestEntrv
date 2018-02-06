package com.javifast.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javifast.model.Persona;

@RestController
public class PersonaController {

    private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/saludo")
    public Persona persona(@RequestParam(value="nombre", defaultValue="JavierMS") String nombre) {
        return new Persona(counter.incrementAndGet(),
                            String.format(template, nombre));
    }
}
