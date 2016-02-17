package co.mutt.dob.model;

import co.mutt.dob.validator.EMail;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user")
public @Data class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    @EMail
    private String email;

    @NotNull
    @Size(min = 1, max = 200)
    private String login;

    @NotNull
    @Size(min = 6, max = 50)
    private String password;

    @NotNull
    @Past
    private Date birth;

    @Size(min = 1, max = 1)
    private boolean status ;

}
