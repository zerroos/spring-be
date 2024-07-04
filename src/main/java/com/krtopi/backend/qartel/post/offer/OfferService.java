package com.krtopi.backend.qartel.post.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }

    public OfferEntity confirmOffer(String offerId) {
        Optional<OfferEntity> optionalOffer = offerRepository.findByOfferId(offerId);
        if (optionalOffer.isPresent()) {
            OfferEntity offer = optionalOffer.get();
            offer.setConfirmed(true); // Assuming there's a field 'confirmed' in the Offer model
            return this.offerRepository.save(offer);
        } else {
            throw new IllegalArgumentException("Offer not found");
        }
    }

    public List<OfferEntity> getOffersByUserId(String userId) {
        return offerRepository.findByUserId(userId);
    }

    public void deleteOfferById(String offerId) {
        if (offerRepository.existsById(offerId)) {
            offerRepository.deleteById(offerId);
        } else {
            throw new IllegalArgumentException("Offer not found");
        }
    }
}
