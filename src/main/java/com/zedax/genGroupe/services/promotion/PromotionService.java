package com.zedax.genGroupe.services.promotion;

import com.zedax.genGroupe.entity.Apprenant;
import com.zedax.genGroupe.entity.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {

    public String addPromotion(Promotion promotion);
    public Promotion  modifierPromotion(Promotion promotion, Long id);
    public List<Promotion> listerPromotion();
    public Promotion AfficherById (Long id);
}
