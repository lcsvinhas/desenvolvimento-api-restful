package org.serratec.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class Teste {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping
    public String oi() {
        return "Oi Mundo";
    }
}