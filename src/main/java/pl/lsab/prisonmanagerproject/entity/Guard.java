package pl.lsab.prisonmanagerproject.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "straznik")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Imie powinno zawierac conajmniej 3 znaki")
    @Column(name = "name")
    private String name;

    @Size(min = 2, message = "Nazwisko powinno zawierac conajmniej 2 znaki")
    @Column(name = "surname")
    private String surname;

    @Min(value = 18, message = "minimum 18 lat")
    @Max(value = 60, message = "maksimum 60 lat")
    @Column(name = "age")
    private int age;

    @OneToOne
    private Cell cell;

    public Guard(Long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}