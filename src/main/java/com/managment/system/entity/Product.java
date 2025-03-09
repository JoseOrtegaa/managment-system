package com.managment.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    @NotNull
    private String name;

    @Column (name = "price")
    @NotNull
    private Double price;

    @Column (name = "qty")
    @NotNull
    private Integer qty;

    @Column (name = "weight")
    @NotNull
    private String weight;

    @Column (name = "category")
    @NotNull
    private String category;

    @Column (name = "img")
    private String img;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
