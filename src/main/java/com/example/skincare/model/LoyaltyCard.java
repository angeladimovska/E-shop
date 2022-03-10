package com.example.skincare.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class LoyaltyCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated;

    private Float points;

    public LoyaltyCard() {
    }

    public LoyaltyCard(LocalDateTime dateCreated, Float points) {
        this.dateCreated = dateCreated;
        this.points = points;
    }
}
