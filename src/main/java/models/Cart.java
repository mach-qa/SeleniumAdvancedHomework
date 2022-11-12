package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Cart {
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalOrderCost = new BigDecimal("0.00");

    public void addProduct(Product product) {
        boolean loopResult = true;

        for (Product value : products) {
            if (value.getProductName().equals(product.getProductName())) {
                increaseQuantity(value, product);
                loopResult = false;
                break;
            }
        }
        if (loopResult) {products.add(product);}
        increaseTotalOrderCost(product.getPrice());
    }

    private void increaseTotalOrderCost(Double productPrice) {
        this.totalOrderCost = totalOrderCost.add(new BigDecimal(String.valueOf(productPrice)));
    }

    private void increaseQuantity (Product actualQuantity, Product newQuantity) {
        int quantity = actualQuantity.getQuantity();
        actualQuantity.setQuantity(quantity + newQuantity.getQuantity());
    }

    public int sizeOfCart() {
        return products.size();
    }

    public List<Product> getCartList (){
        return getProducts();
    }
}
