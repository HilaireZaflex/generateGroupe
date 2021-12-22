package com.zedax.genGroupe.services.groupe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import com.zedax.genGroupe.entity.Apprenant;
import com.zedax.genGroupe.entity.Groupe;
import com.zedax.genGroupe.repository.ApprenantRepository;
import com.zedax.genGroupe.repository.GroupeRepository;
import com.zedax.genGroupe.repository.PromotionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeServiceImpl implements GroupeService{
    //Type de tirage
    final String ALEATOIRE = "ALEATOIRE";

    @Autowired
    GroupeRepository groupeRepository;

    @Autowired
    ApprenantRepository apprenantRepository;

    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public String addGroupe(Groupe groupe) {
        groupeRepository.save(groupe);
        return "Nouveau groupe ajouté avec succès !";
    }

    @Override
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @Override
    public Groupe getGroupeById(Long groupeId) {
        return groupeRepository.findById(groupeId).get();
    }

    @Transactional
    @Override
    public void modifyGroupe(Long groupeId, Groupe groupe) {
        Groupe groupeExistant = groupeRepository.findById(groupeId).get();
        groupeExistant.setNom(groupe.getNom());
    }

    @Override
    public String deleteGroupe(Long groupeId) {
        groupeRepository.deleteById(groupeId);
        return "Le groupe supprimé avec succès !";
    }

    @Override
    public List<Groupe> generateGroupesByNbGroupes(Integer nombreGroupe, String tri)
    {
        //Listes des apprenants
        List<Apprenant> allApprenants = apprenantRepository.findAll();

        List<Groupe> genGroup = new ArrayList<>();

        if(tri.equals(ALEATOIRE))
        {
            //Shuffle liste
            Collections.shuffle(allApprenants);
        }

        List<List<Apprenant>> listGroupeGenetayed = IntStream.range(0, allApprenants.size())
            .boxed()
            .collect(Collectors.groupingBy(i -> i % nombreGroupe))
            .values()
            .stream()
            .map(il -> il.stream().map(allApprenants::get).collect(Collectors.toList()))
            .collect(Collectors.toList());
        
        for(int i = 0; i < nombreGroupe; i++)
        {
            Groupe groupe = new Groupe();
            groupe.setNom("Groupe "+i);
            groupe.setApprenants(listGroupeGenetayed.get(i));
            groupeRepository.save(groupe);
            genGroup.add(groupe);
        }
        
        return genGroup;
    }
    
}
