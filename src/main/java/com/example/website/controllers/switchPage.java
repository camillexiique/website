package com.example.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class switchPage {

    @GetMapping("/home")
    public String GoToHome(Model model){


        return "App";
    }

    @GetMapping("/categorie")
    public String GoToCategorie(Model model){


        return "Categorie";
    }

    @GetMapping("/product")
    public String GoToProduct(Model model){

        return "Article";
    }


}
