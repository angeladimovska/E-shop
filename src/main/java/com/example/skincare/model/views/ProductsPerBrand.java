package com.example.skincare.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Subselect("SELECT * FROM public.products_per_brand")
@Immutable
public class ProductsPerBrand {

    @Id
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    @Column(name = "brand_id")
    private Long brand;

}