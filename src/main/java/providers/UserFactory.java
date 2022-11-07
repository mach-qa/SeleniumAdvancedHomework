package providers;

import com.github.javafaker.Faker;
import models.User;

import java.text.SimpleDateFormat;

public class UserFactory {

    static Faker faker = new Faker();

    public static User getRandomUser() {
        SimpleDateFormat simple = new SimpleDateFormat("MM/dd/yyyy");
        return User.builder()
                .userFirstName(faker.name().firstName())
                .userLastName(faker.name().lastName())
                .userEmail(faker.internet().emailAddress())
                .userPassword(faker.internet().password())
                .userBirthday(simple.format(faker.date().birthday()))
                .build();
    }

    public static User getAlreadyRegisteredUser() {
        return User.builder()
                .userEmail(System.getProperty("email"))
                .userPassword(System.getProperty("password"))
                .build();
    }
}
