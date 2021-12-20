package com.zedax.genGroupe.services.groupe;

import java.util.List;

import javax.transaction.Transactional;

import com.zedax.genGroupe.entity.Groupe;
import com.zedax.genGroupe.repository.GroupeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeServiceImpl implements GroupeService{
    @Autowired
    GroupeRepository groupeRepository;

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
    public List<Groupe> generatGroupes() {
        return null;
    }
    
}
