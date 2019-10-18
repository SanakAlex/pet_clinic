package sanak.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

  @RequestMapping(path = {"/vets", "/vets/index", "/vets/index.html"})
  public String listVets() {
    return "vets/index";
  }
}
