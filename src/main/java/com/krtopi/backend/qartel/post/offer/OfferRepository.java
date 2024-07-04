package com.krtopi.backend.qartel.post.offer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends MongoRepository<OfferEntity, String> {
    Optional<OfferEntity> findByOfferId(String offerId);
    OfferEntity save(OfferEntity offer);
    List<OfferEntity> findByUserId(String id);
}
