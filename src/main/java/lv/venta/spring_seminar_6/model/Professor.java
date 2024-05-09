package lv.venta.spring_seminar_6.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")
@Entity
public class Professor extends Person{

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idp;

    @NotNull
    @Column(name = "Degree")
    private Degree degree;

    @OneToOne(mappedBy = "professor")//ir otras klases mainīgā nosaukums
    @ToString.Exclude
    private Course course;

    public Professor(String name, String surname, Degree degree) {
        super(name, surname);
        setDegree(degree);
    }
}