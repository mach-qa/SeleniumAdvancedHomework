package models;


import lombok.Builder;

@Builder
public class User {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userBirthday;
}
