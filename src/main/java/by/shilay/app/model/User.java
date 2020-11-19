package by.shilay.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String login;
    private String password;
    private String birthdate;

    public User (String login, String password, String birthDate){
        this.login = login;
        this.password = password;
        this.birthdate = birthDate;
    }

    public User(int id, String login, String password, String birthdate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
    }
}
