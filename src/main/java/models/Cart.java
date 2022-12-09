package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalOrderCost = new BigDecimal("0.00");

    public void addProduct(Product productToAdd) {
        increaseTotalOrderCost(productToAdd.getPrice(), productToAdd.getQuantity());

        for (Product product : products) {
            if (product.getProductName().equals(productToAdd.getProductName())) {
                product.updateQuantity(productToAdd.getQuantity());
                return;
            }
        }
        products.add(productToAdd);
    }

    private void increaseTotalOrderCost(Double productPrice, int productQuantity) {
        this.totalOrderCost = totalOrderCost.add(new BigDecimal(String.valueOf(productPrice * productQuantity)));
    }

    public List<Product> getAmountOfProductsInCart(){
        return getProducts();
    }
}