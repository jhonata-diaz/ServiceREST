package com.ucb.FramkyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;


    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping("/greeting")
    public String greeting() {
        return greetingService.getGreeting();
    }


    @PostMapping("/add")
    public ResponseEntity<String> postGreeting(@RequestBody GreetingRequest greetingRequest) {
        String nombre = greetingRequest.getNombre();

        GreetingService nuevo=greetingService.MensajeConNombre(nombre);
        if (nuevo == null) {


            return ResponseEntity.ok(nuevo.getMensajeNuevoConNombre());
        }else{
            return ResponseEntity.notFound().build();
        }

    }


    @PostMapping("/add/{lang}")
    public ResponseEntity<String> postGreeting(@RequestBody GreetingRequest greetingRequest,
                                               @PathVariable("lang") String lang) {
        String nombre = greetingRequest.getNombre();

        if (nombre != null && !nombre.isEmpty()) {
            greetingService.MensajeConNombre(nombre);
            return ResponseEntity.ok(greetingService.getNombre()+" "+greetingService.translateText(lang));
        } else {
            return ResponseEntity.badRequest().body("El nombre no puede estar vacío");
        }
    }

}























