package sanak.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sanak.springframework.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @RequestMapping(method = RequestMethod.GET, path = {"", "/", "/index", "/index.html"})
  public String listVets(Model model) {
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }
}
