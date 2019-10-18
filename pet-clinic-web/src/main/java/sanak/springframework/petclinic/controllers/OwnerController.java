package sanak.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

  @RequestMapping(path = {"", "/", "/index", "/index.html"})
  public String listVets() {
    return "owners/index";
  }
}
