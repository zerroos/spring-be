package com.krtopi.backend.qartel.post.offer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/offers")
public class OfferController {
    private OfferService offerService;
    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }

    @PutMapping("/{offerId}")
    public OfferEntity confirmOffer(@PathVariable String offerId, @RequestParam String action) {
        if ("confirm".equals(action)) {
            return offerService.confirmOffer(offerId);
        } else {
            throw new IllegalArgumentException("Invalid action");
        }
    }

    // GET /api/offers?userId={userId}
    @GetMapping
    public List<OfferEntity> getOffersByUserId(@RequestParam String userId) {
        return offerService.getOffersByUserId(userId);
    }

    // DELETE /api/offers/{offerId}
    @DeleteMapping("/{offerId}")
    public void deleteOfferById(@PathVariable String offerId) {
        offerService.deleteOfferById(offerId);
    }
}
