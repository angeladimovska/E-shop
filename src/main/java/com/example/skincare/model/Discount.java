package com.example.skincare.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated;

    private LocalDateTime validUntil;

    public Discount() {
    }

    public Discount(LocalDateTime dateCreated, LocalDateTime validUntil) {
        this.dateCreated = dateCreated;
        this.validUntil = validUntil;
    }

}
