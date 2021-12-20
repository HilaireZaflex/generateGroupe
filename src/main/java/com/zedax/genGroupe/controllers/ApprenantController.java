package com.zedax.genGroupe.controllers;

import com.zedax.genGroupe.entity.Apprenant;
import com.zedax.genGroupe.services.apprenant.ApprenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ApprenantController {
    @Autowired
    ApprenantServiceImpl apprenantService;

    @PostMapping("/addApprenant")
    String addApprenant(@RequestBody Apprenant apprenant){

        return apprenantService.addApprenant(apprenant);
    }


    @GetMapping("/listerApprenant")
    List<Apprenant> listerApprenant(){

        return apprenantService.listerApprenant();
    }


    @PutMapping("/modifierApprenant/{id}")
    Apprenant modifierApprenant(@RequestBody Apprenant apprenant, @PathVariable Long id){
        return apprenantService.modifierApprenant(apprenant, id);
    }


    @DeleteMapping("/supprimerApprenant/{id}")
     void supprimerApprenant(@RequestBody Apprenant apprenant, @PathVariable Long id){
        apprenantService.supprimerApprenant(id);
    }


    @GetMapping("/detailApprenant/{id}")
    Apprenant AfficherById(@PathVariable Long id){
        return apprenantService.AfficherById(id);
    }


}
