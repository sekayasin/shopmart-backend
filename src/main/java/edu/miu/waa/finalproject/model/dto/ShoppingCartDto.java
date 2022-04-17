package edu.miu.waa.finalproject.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.miu.waa.finalproject.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartDto {

    @JsonProperty("cart_id")
    private long cartId;
    @JsonProperty("products")
    private List<Product> products;
}
