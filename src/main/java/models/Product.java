package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Product {

    String productName;
    Double price;
    int quantity;
    Double totalPrice;

    public Product(String productName, Double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
    }
}
