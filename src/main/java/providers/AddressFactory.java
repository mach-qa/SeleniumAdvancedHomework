package providers;

import com.github.javafaker.Faker;
import models.Address;

public class AddressFactory {

    static Faker faker = new Faker();

    public static Address setNewAddressForRegisteredUser() {
        return Address.builder()
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .zipPostalCode(faker.address().zipCode())
                .build();
    }
}
