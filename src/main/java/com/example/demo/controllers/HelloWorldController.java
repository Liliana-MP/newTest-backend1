package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/hej")
    public String hej(@RequestParam (required = false) String name){
        if (name == null) return "Hello utan namn";
        return "Hello " + name;
    }

    @RequestMapping("/hej2")
    public String hej2(@RequestParam (defaultValue = "Lili") String firstname,
                       @RequestParam (defaultValue = "Pitra") String lastname){
        return "Hello " + firstname + " " + lastname;
    }

    @RequestMapping("/hej3")
    public String hej3(@RequestParam List<String> names){
        return "Hello " + names;
    }
    // localhost:8080/hej3?names=bajs,kiss,hest
    // Detta kallas för query parametrar (därför man skriver ? efter metodnamnet)


    // Detta är en path parameter {name}
    @RequestMapping("/hejPathParam/{name}")
    public String hejPathParam(@PathVariable String name){
        if (name == null) return "Hello world ";
        return "Hello " + name;
    }

    @RequestMapping("/hejhtml")
    public String hejhtml(){
        return "<html><head><body><h1>hejsan</h1></body></head></html>";
    }


}
