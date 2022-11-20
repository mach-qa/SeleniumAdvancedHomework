package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private String alias;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String addressComplement;
    private String city;
    private String zipPostalCode;
    private int phone;
    private String state;
    private String country;
}
