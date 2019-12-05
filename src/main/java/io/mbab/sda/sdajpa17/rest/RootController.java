package io.mbab.sda.sdajpa17.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// klasa bedzie wystawiac pewien zasob springowy ktory bedziemy mogli otworzyc w przegladarce

@RestController // aby spring zarzadzal klasa wystawia pewien zasoob na siec po protokole http
@RequestMapping("Bart") // na jkaiej sciezce ma sie zasob otwierac , ,mapping dla calej klasy

public class RootController {

    @GetMapping("") // jaka metoda jest uzywana
    // metoda get dziala na pasku przeklagarki
    String getText(){
        return "Czesc Bartek! :)";
    }




}
