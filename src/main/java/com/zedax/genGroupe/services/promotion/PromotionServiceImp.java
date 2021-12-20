package com.zedax.genGroupe.services.promotion;

import com.zedax.genGroupe.entity.Promotion;
import com.zedax.genGroupe.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImp implements  PromotionService{
    @Autowired
    PromotionRepository promotionRepository;


    public String addPromotion(Promotion promotion) {
        promotionRepository.save(promotion);
        return "Promotion ajouté";
    }

    @Override
    public Promotion modifierPromotion(Promotion promotion, Long id) {
            Promotion promotion1 = promotionRepository.findById(id).get();
            promotion1.setPromoAnnee(promotion.getPromoAnnee());
            promotion1.setPromoNom(promotion.getPromoNom());
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> listerPromotion() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion AfficherById(Long id) {
        return promotionRepository.findById(id).get();
    }
}
