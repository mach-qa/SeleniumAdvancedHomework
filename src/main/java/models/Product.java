package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    String productName;
    Double price;
    int quantity;
    //TODO Dodać Pole Double które będzie mnożnikiem quantity i price
}
