package com.krtopi.backend.qartel.post.offer;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "offers")
public class OfferEntity {
    @Id
    private String offerId;
    private String postId;
    private String sellerId;
    private float offerPrice;
    private int offerQuantity;
    private String[] comments;
    private String userId;
    private String buyerId;
    private Date createdAt;
    private boolean sellOrBuy;
    private boolean confirmed = false;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public float getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(float offerPrice) {
        this.offerPrice = offerPrice;
    }

    public int getOfferQuantity() {
        return offerQuantity;
    }

    public void setOfferQuantity(int offerQuantity) {
        this.offerQuantity = offerQuantity;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSellOrBuy() {
        return sellOrBuy;
    }

    public void setSellOrBuy(boolean sellOrBuy) {
        this.sellOrBuy = sellOrBuy;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
