package models;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public Product(WebElement cartItem) {
        this.productName = cartItem.findElement(By.cssSelector(".product-line-info a")).getText();
        this.price = Double.parseDouble(
                cartItem.findElement(By.cssSelector(".current-price .price"))
                        .getText()
                        .replace(System.getProperty("currencySymbol"), ""));
        this.quantity = Integer.parseInt(
                cartItem.findElement(By.cssSelector("input.form-control"))
                        .getAttribute("value"));
        this.totalPrice = price * quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity+=quantity;
        this.totalPrice = price *this.quantity;
    }
}
