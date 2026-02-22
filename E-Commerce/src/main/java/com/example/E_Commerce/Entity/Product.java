package com.example.E_Commerce.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "ecom_product")
public class Product {

    //ORM ->Object Relation mapping

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_description")
    private String description;

    @Min(1)
    @Column(name = "product_price", nullable = false)
    private float price;


}
