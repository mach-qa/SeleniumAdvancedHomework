package providers;

import com.github.javafaker.Faker;
import models.Address;

import java.util.Locale;

public class AddressFactory {

    static Faker usFaker = new Faker(new Locale("en-US"));

    public static Address getRandomUSAddress() {
        return Address.builder()
                .address(usFaker.address().streetAddress())
                .city(usFaker.address().city())
                .zipPostalCode(usFaker.numerify("#####"))
                .build();
    }
}
