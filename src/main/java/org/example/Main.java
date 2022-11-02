package org.example;

import models.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user = User.builder()
                .userEmail("ffr@wp.pl")
                .userFirstName("Piotr")
                .userLastName("Machnicki")
                .userPassword("123456")
                .build();

        System.out.println(user.toString());
    }
}