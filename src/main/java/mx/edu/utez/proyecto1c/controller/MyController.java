package mx.edu.utez.proyecto1c.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mx.edu.utez.proyecto1c.dto.RequestBodyDTO; // <-- Importación que faltaba

@RestController
@CrossOrigin({"*"})
@RequestMapping("/my-services")
public class MyController {

    @GetMapping
    public String miPrimerServicio() {

        return "hello world";
    }

    @GetMapping("/servicio2")
    public String servicio2() {

        return "segundo servicio";
    }

    @PostMapping
    public String servicio3() {

        return "este es el servicio3";
    }

    @GetMapping("/path/{id}")
    public String pathvariable(@PathVariable String id) {

        return "el path variable es: " + id;
    }

    @PostMapping("/body")
    public ResponseEntity <RequestBodyDTO>  body(@RequestBody @Valid RequestBodyDTO payload) {
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(payload);
    }


    ///////////////////tarea U2 - A1 - Fibonacci y FizzBuzz/////////////////



    private final String nombre_alumno = "Arantza Saddai Hernandez Martinez";


    @GetMapping("/fizzbuzz/{n}")
    public String fizzBuzz(@PathVariable int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return nombre_alumno;
    }



    @GetMapping("/fibonacci/{n}")
    public String fibonacci(@PathVariable int n) {
        if (n >= 1) System.out.println(0);
        if (n >= 2) System.out.println(1);

        int n1 = 0;
        int n2 = 1;

        for (int i = 3; i <= n; i++) {
            int current = n1 + n2;
            System.out.println(current);
            n1 = n2;
            n2 = current;
        }
        return nombre_alumno;
    }
}