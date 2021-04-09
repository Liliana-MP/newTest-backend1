package com.example.demo.controllers.ovning1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Ovning1 {

    // Övning 1b
    @RequestMapping("/randomnumber")
    public String randomNumber(){
        int rand = (int)(Math.random() * 9) + 1;
        return "Ditt random nummer är " + rand;
    }

    @RequestMapping("/randomanimal")
    public String randomAnimal(){
        int rand = (int)(Math.random() * 9) + 1;
        List<String> animalList = new ArrayList<>();
        String animal = "";
        animalList.add("Cat");
        animalList.add("Dog");
        animalList.add("Snejk");
        animalList.add("Åsna");
        animalList.add("Bajskorv");
        animalList.add("Hest");
        animalList.add("Elefant");
        animalList.add("Fågel");
        animalList.add("Fisk");
        animalList.add("Kiss");


        animal = animalList.get(rand);

        return "ditt random djur är " + animal;
    }

    @RequestMapping("/lucky")
    public String lucky(@RequestParam String luckyYou){
        if (luckyYou.equals("animal")){
            return randomAnimal();
        } else if (luckyYou.equals("number")){
            return randomNumber();
        }

        return "Du måste skriva animal eller number";

    }
    // Övning 1c
    @RequestMapping("/lucky2")
    public String lucky2(@RequestParam (required = false) String firstname,
                         @RequestParam (required = false) String lastname){
        if (firstname.isEmpty() && lastname.isEmpty()){
            return randomAnimal();
        } else if (lastname.isEmpty()){
            return  firstname + " " + randomAnimal();
        } else if(firstname.isEmpty()){
            return  lastname + " " + randomAnimal();
        }

        return firstname + " " + lastname + " " + randomAnimal();

    }


    // Övning 1d
    @RequestMapping("/lucky3")
    public String lucky3(@RequestParam (defaultValue = "Användare") String firstname,
                         @RequestParam (defaultValue = "Bajs") String lastname){

        return firstname + " " + lastname + " " + randomAnimal();

    }
}
