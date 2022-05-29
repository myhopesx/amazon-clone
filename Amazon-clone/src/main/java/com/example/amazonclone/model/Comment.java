package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;


@Data
@AllArgsConstructor
public class Comment {

    @NotEmpty(message = "id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String id;

    @NotEmpty(message = "id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String productId;

    @NotEmpty(message = "userid cannot be empty")
    @Size(min = 3,max = 3 , message = "user id have to be 5 character long")
    private String userid;

    @NotEmpty(message = "userid cannot be empty")
    @Size(min = 6,max = 6, message = "message have to be 6 character long")
    private String message;

    @NotNull(message = "rate cannot be empty")
    @Min(value = 1 , message = "rate must be a number between 1 - 5 ")
    @Max(value = 5,message = "rate must be a number between 1 - 5 ")
    private Double rate;

}
