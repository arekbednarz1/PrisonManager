package pl.lsab.prisonmanagerproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, message = "imię powinno zawierać minimum 3 znaki")
    @NotNull
    @NotEmpty
    private String firstName;

    @Size(min = 3, message = "nazwisko powinno zawierać minimum 3 znaki")
    @NotNull
    @NotEmpty
    private String lastName;

    @Size(min = 5, message = "Minimum 5 znaków")
    @NotNull
    @NotEmpty
    private String password;

    @Transient
    private String passwordRepeat;

}
