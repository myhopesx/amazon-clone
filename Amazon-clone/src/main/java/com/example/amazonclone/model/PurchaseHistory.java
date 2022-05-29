package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class PurchaseHistory {

    @NotEmpty(message = "id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String id;

    @NotEmpty(message = "userid cannot be empty")
    @Size(min = 5,max = 5 , message = "user id have to be 5 character long")
    private String userid;

    @NotEmpty(message = "product Id cannot be empty")
    @Size(min = 3,max = 3 , message = "product id have to be 3 character long")
    private String productId;

    @NotNull(message = "price cannot be empty")
    @Positive( message = "price must be positive number")
    private Double price;

}
