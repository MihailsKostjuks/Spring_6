package lv.venta.spring_seminar_6.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person {

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z]{1}[a-z]+") //TODO nokopēt no iepriekšējiem semināriem arī ar mīkstinājumu/garumu zīmēm
    @Column(name = "Name")
    private String name;

    @NotNull
    @Size(min = 2, max = 40)
    @Pattern(regexp = "[A-Z]{1}[a-z]+") //TODO nokopēt no iepriekšējiem semināriem arī ar mīkstinājumu/garumu zīmēm
    @Column(name = "Surname")
    private String surname;

    public Person(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

}
