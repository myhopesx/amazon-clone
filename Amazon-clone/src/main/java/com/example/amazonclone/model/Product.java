package com.example.amazonclone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class Product {

    @NotEmpty(message = "Id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3,max = 3 , message = "name have to be 3 character long")
    private String name;

    @NotNull(message = "price cannot be empty")
    @Positive( message = "price must be positive number")
    private Double price;

    @NotEmpty(message = "categoryID cannot be empty")
    @Size(min = 3,max = 3 , message = "categoryID have to be 3 character long")
    private String categoryID;

}
