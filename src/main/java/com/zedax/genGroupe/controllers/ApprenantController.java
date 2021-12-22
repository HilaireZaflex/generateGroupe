package com.zedax.genGroupe.controllers;

import com.zedax.genGroupe.entity.Apprenant;
import com.zedax.genGroupe.services.apprenant.ApprenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/apprenant")
public class ApprenantController {
    @Autowired
    ApprenantServiceImpl apprenantServiceImpl;

    @PostMapping("/addApprenant")
    String addApprenant(@RequestBody Apprenant apprenant){
        return apprenantServiceImpl.addApprenant(apprenant);
    }
    @GetMapping("/listerApprenant")
    List<Apprenant> listerApprenant(){
        return apprenantServiceImpl.listerApprenant();
    }

    @PutMapping("/modifierApprenant/{id}")
    Apprenant modifierApprenant(@RequestBody Apprenant apprenant, @PathVariable Long id){
        return apprenantServiceImpl.modifierApprenant(apprenant, id);
    }



}
