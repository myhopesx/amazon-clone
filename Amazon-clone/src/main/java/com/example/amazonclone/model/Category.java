package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class Category {

    @NotEmpty(message = "Id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3,max = 3 , message = "name have to be 3 character long")
    private String name;

}
