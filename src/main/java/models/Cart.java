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

    public void addProduct(Product product) {
        boolean loopResult = true;

        for (Product value : products) {
            if (value.getProductName().equals(product.getProductName())) {
                increaseQuantity(value, product);
                recalculateTotalPrice(value);
                loopResult = false;
                break;
            }
        }
        if (loopResult) {products.add(product);}
        increaseTotalOrderCost(product.getPrice(), product.getQuantity());
    }

    private void increaseTotalOrderCost(Double productPrice, int productQuantity) {
        this.totalOrderCost = totalOrderCost.add(new BigDecimal(String.valueOf(productPrice * productQuantity)));
    }

    private void increaseQuantity (Product actualQuantity, Product newQuantity) {
        int quantity = actualQuantity.getQuantity();
        actualQuantity.setQuantity(quantity + newQuantity.getQuantity());
    }

    public void recalculateTotalPrice(Product totalPrice) {
        totalPrice.setTotalPrice(totalPrice.getPrice() * totalPrice.getQuantity());
    }

    public List<Product> getCartList (){
        return getProducts();
    }
}
