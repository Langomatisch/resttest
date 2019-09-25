package de.langomatisch.test.account;

import de.langomatisch.test.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String username;
    // what do on password??
    private String password;
    @OneToOne
    private User user;

}
