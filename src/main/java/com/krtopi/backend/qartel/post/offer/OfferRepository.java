package com.krtopi.backend.qartel.post.offer;

import com.krtopi.backend.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends MongoRepository<UserEntity, String> {
    Optional<OfferEntity> findByOfferId(String offerId);
    OfferEntity save(OfferEntity offer);
    List<OfferEntity> findByUserId(String id);
}
