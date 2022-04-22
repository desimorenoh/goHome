package org.factoriaf5.gohome.controller;

import org.factoriaf5.gohome.repositories.ClientRepository;
import org.factoriaf5.gohome.repositories.CategoryRepository;
import org.factoriaf5.gohome.repositories.GoHome;
import org.factoriaf5.gohome.repositories.GoHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoHomeController {
    private GoHomeRepository goHomeRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    public GoHomeController(GoHomeRepository goHomeRepository, ClientRepository clientRepository, CategoryRepository categoryRepository) {

        this.goHomeRepository = goHomeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/homes")
    String listHomes(Model model, @RequestParam(required = false) String category) {
        List<GoHome> homes = (List<GoHome>) goHomeRepository.findAll();
        model.addAttribute("title", "Lista de Casas");
        model.addAttribute("homes", homes);
        return "homes/all";
    }

    @GetMapping("/homes/new")
    String newGoHome(Model model) {
        GoHome goHome = new GoHome();
        model.addAttribute("goHome", goHome);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("title", "Añadir una nueva Casa");
        return "homes/edit";
    }

    @GetMapping("/homes/edit/{id}")
    String editGoHome(Model model, @PathVariable Long id) {
        GoHome goHome = goHomeRepository.findById(id).get();
        model.addAttribute("goHome", goHome);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("title", "Editar Casa");
        return "homes/edit";
    }

    @PostMapping("/homes/new")
    String addGoHome(@ModelAttribute GoHome goHome) {
        goHomeRepository.save(goHome);
        return "redirect:/homes";
    }

    @GetMapping("/homes/delete/{id}")
    String remove(@PathVariable Long id) {
        goHomeRepository.deleteById(id);
        return "redirect:/homes";
    }

    @GetMapping("/homes/search")
    String searchHome(@RequestParam String word, Model model) {
        List<GoHome> goHomes = goHomeRepository.findGoHomeByTitleContainingIgnoreCase(word);
        model.addAttribute("title", String.format("Casas que contienen \"%s\"", word));
        model.addAttribute("homes", goHomes);

        return "homes/all";
    }


    @GetMapping("/homes/detalles/{id}")
    String GoHomeDetalle(Model model, @PathVariable Long id) {
        GoHome goHome = goHomeRepository.findById(id).get();
        model.addAttribute("Detail", goHome);
        model.addAttribute("title", "Detalles de la Casa");
        return "homes/detalles";
    }

}
