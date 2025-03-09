package com.managment.system.dtos;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private String type_product;
    @NotNull
    private Integer userId;
}
