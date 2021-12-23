package com.zedax.genGroupe.services.apprenant;


import com.zedax.genGroupe.entity.Apprenant;
import com.zedax.genGroupe.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public void modifierApprenant(Apprenant apprenant, Long id) {
            Apprenant apprenant1 = apprenantRepository.findById(id).get();
            apprenant1.setNomComplet(apprenant.getNomComplet());
            apprenant1.setEmail(apprenant.getEmail());
            apprenant1.setTel(apprenant.getTel());
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
