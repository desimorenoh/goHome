package org.factoriaf5.gohome.controller;


import org.factoriaf5.gohome.repositories.CategoryRepository;
import org.factoriaf5.gohome.repositories.GoHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    private GoHomeRepository goHomeRepository;
    private CategoryRepository filterRepository;

    @Autowired
public HomeController(GoHomeRepository goHomeRepository, CategoryRepository filterRepository) {
        this.goHomeRepository = goHomeRepository;
        this.filterRepository = filterRepository;
    }

    @GetMapping(path = {"/", "/home", "/index"})
    public String goHome(Model model) {
        model.addAttribute("title", "Lista de Casas");
        model.addAttribute("homes", goHomeRepository.findAll());
        return "home";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
