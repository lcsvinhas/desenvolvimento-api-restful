package org.serratec.backend.revisao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploController {

    @GetMapping
    public String teste(@RequestParam String nome) {
        return nome.toUpperCase();
    }

    @GetMapping("/teste")
    public String teste2() {
        return "Java";
    }

    @GetMapping("/soma")
    public String soma(@RequestParam Integer a, @RequestParam Integer b) {
        return "" + (a + b);
    }
}