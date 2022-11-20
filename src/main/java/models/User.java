package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userBirthday;
}
