package com.zedax.genGroupe.controllers;

import java.util.List;

import com.zedax.genGroupe.entity.Groupe;
import com.zedax.genGroupe.services.groupe.GroupeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/groupe")
public class GroupeController
{
    @Autowired
    GroupeServiceImpl groupeServiceImpl;

    @PostMapping(path = "/addGroupe")
    public String addGroupe(@RequestBody Groupe groupe)
    {
        return groupeServiceImpl.addGroupe(groupe);
    }

    @GetMapping(path = "/getAllGroupes")
    public List<Groupe> getAllGroupe()
    {
        return groupeServiceImpl.getAllGroupes();
    }

    @GetMapping(path = "/getGroupeById/{groupeId}")
    public Groupe getGroupeById(@PathVariable("groupeId") Long groupeId)
    {
        return groupeServiceImpl.getGroupeById(groupeId);
    }

    @DeleteMapping(path = "/deleteGroupe/{groupeId}")
    public String deleteGroupe(@PathVariable("groupeId") Long groupeId)
    {
        return groupeServiceImpl.deleteGroupe(groupeId);
    }

    @PutMapping(path = "/updateGroupe/{groupeId}")
    public String updateGroupe(@PathVariable("groupeId") Long groupeId, @RequestBody Groupe groupe)
    {
        groupeServiceImpl.modifyGroupe(groupeId, groupe);
        return "Modification éffectuée avec succès !";
    }

    @GetMapping("/genGroupe/{nbGroupe}")
    public List<Groupe> generatGroupes(@PathVariable("nbGroupe") Integer nombreGroupe, @RequestParam String tri)
    {
        return groupeServiceImpl.generateGroupesByNbGroupes(nombreGroupe, tri);
    }
}
