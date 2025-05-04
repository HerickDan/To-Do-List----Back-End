package com.project.backEnd.tdlBackEnd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class new_controller {
   @GetMapping("/hello")
    public String hello(){
       return("Hello");
   }
}
