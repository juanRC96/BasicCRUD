package com.BasicCRUD.controller;

import com.BasicCRUD.models.Persona;
import com.BasicCRUD.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model){

        var personas = personaService.listarPersonas();

        model.addAttribute("personas",personas);

        return "index";
    }

    @GetMapping("/agregar")
    //INYECTA UNA NUEVA PERSONA COMO PARAMETRO
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    //SI YA HAY UN OBJETO DEL TIPO PERSONA LO UTILIZA
    public String guardar(Persona persona){
       personaService.guardar(persona);
       return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    //DE MANERA AUTOMATICA SPRING INYECTA EL OBJETO DE TIPO PERSONA CON EL ID COINCIDENTE
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }

    //CON QUERY PARAMETER (SE PODRIA HACER IGUAL QUE EL EDITAR)
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
