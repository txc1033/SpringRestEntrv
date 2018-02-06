package com.javifast.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="/inicio")
    public String Inicio() {
    	return "index";
    }
}
