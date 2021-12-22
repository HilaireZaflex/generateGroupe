package com.zedax.genGroupe.services.groupe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public List<Groupe> generateGroupesByNbGroupes(Integer nombreGroupe)
    {

        //Random class
        Random random = new Random();

        //Listes des apprenants
        List<Apprenant> allApprenants = apprenantRepository.findAll();

        //Nombre d'apprenants
        Integer nombreApprenants = apprenantRepository.findAll().size();

        //Liste des groupes générés et leurs membres
        List<Groupe> groupeGenerated = new ArrayList<Groupe>();
        List<Apprenant> listAppGene = new ArrayList<>();

        Integer nbMemberPerGroup = 0;
        Integer nbMemberNoAffect;

        if((nombreApprenants % nombreGroupe) != 0)
        {
            nbMemberNoAffect = nombreApprenants % nombreGroupe;
            nbMemberPerGroup = (nombreApprenants - nbMemberNoAffect) / nombreGroupe;

            for(int i = 1; i <= nombreGroupe; i++)
            {
                for(int j = 0; j < nbMemberPerGroup; j++)
                {
                    int randomIndex = random.nextInt(allApprenants.size());
                    Apprenant randomApprenant = allApprenants.get(randomIndex);
                    listAppGene.add(randomApprenant);
                    allApprenants.remove(randomIndex);
                }

                Groupe groupe = new Groupe();
                groupe.setNom("Groupe "+i);
                groupe.setApprenants(listAppGene);;
                groupeRepository.save(groupe);
                groupeGenerated.add(groupe);
                listAppGene.clear();
            }
        }
        else
        {
            nbMemberPerGroup = nombreApprenants / nombreGroupe;
            for(int i = 1; i <= nombreGroupe; i++)
            {
                for(int j = 0; j < nbMemberPerGroup; j++)
                {
                    int randomIndex = random.nextInt(allApprenants.size());
                    Apprenant randomApprenant = allApprenants.get(randomIndex);
                    listAppGene.add(randomApprenant);
                    allApprenants.remove(randomIndex);
                }

                Groupe groupe = new Groupe();
                groupe.setNom("Groupe "+i);
                groupe.setApprenants(listAppGene);
                groupeRepository.save(groupe);
                groupeGenerated.add(groupe);
                listAppGene.clear();
            }
        }
        return groupeGenerated;
    }
    
}
