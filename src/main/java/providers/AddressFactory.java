package providers;

import com.github.javafaker.Faker;
import models.Address;

import java.util.Locale;

public class AddressFactory {

    static Faker usfaker = new Faker(new Locale("en-US"));

    public static Address setNewAddressForRegisteredUser() {
        return Address.builder()
                .address(usfaker.address().streetAddress())
                .city(usfaker.address().city())
                .zipPostalCode(usfaker.numerify("#####"))
                .build();
    }
}
