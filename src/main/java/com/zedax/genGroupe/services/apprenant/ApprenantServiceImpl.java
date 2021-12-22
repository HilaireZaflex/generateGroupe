package com.zedax.genGroupe.services.apprenant;


import com.zedax.genGroupe.entity.Apprenant;
import com.zedax.genGroupe.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantServiceImpl implements ApprenantService {

    @Autowired
    ApprenantRepository apprenantRepository;

    @Override
    public String addApprenant(Apprenant apprenant) {
        apprenantRepository.save(apprenant);
        return "Apprenant ajouté";
    }

    @Override
    public Apprenant modifierApprenant(Apprenant apprenant, Long id) {

            Apprenant apprenant1 = apprenantRepository.findById(id).get();
            apprenant1.setNomComplet(apprenant.getNomComplet());
            apprenant1.setEmail(apprenant.getEmail());
            apprenant1.setTel(apprenant.getTel());
        return  apprenantRepository.save(apprenant);

    }

    @Override
    public void supprimerApprenant(Long id) {
        apprenantRepository.deleteById(id);
    }

    @Override
    public List<Apprenant> listerApprenant() {

        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant AfficherById(Long id) {

        return apprenantRepository.findById(id).get();
    }
}
