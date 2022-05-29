package com.example.amazonclone.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotEmpty(message = "Id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String id;

    @NotEmpty(message = "productId cannot be empty")
    @Size(min = 3,max = 3 , message = "productId have to be 3 character long")
    private String productId;

    @NotEmpty(message = "merchant id cannot be empty")
    @Size(min = 3,max = 3 , message = "merchant id  have to be 3 character long")
    private String merchantId ;

    @NotNull(message = "stock cannot be empty")
    @Min(value = 10)
    private Integer stock;
}
