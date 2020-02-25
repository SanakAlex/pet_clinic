package sanak.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sanak.springframework.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @GetMapping({"", "/", "/index", "/index.html"})
  public String listVets(Model model) {
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }

  @GetMapping("/find")
  public String findOwners() {
    return "notimplemented";
  }
}
