package com.example.skincare.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition="TEXT", length = 2048)
    private String image;

    public Brand() {
    }

    public Brand(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Brand(String name) {
        this.name = name;
    }
}
