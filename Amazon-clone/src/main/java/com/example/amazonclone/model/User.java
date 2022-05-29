package com.example.amazonclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String id ;

    @NotEmpty(message = "username cannot be empty")
    @Size(min = 5,max = 5 , message = "username have to be 5 character long")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Size(min = 6,max = 6, message = "password have to be 6 character long")
    @Pattern(regexp = "^[0-9]*[a-zA-Z]+[a-zA-Z0-9]*$" , message = "password must have characters and digits")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "role cannot be empty")
    @Pattern(regexp = "(Admin|Customer)" , message ="role have to be in ( “Admin”,”Customer”)" )
    private String role;

    @NotNull(message = "balance cannot be empty")
    @Positive(message = "balance have to be positive")
    private Double balance;

}
