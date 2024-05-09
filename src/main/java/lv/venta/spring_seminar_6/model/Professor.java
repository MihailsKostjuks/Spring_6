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
public class Professor {

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idp;

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

    @NotNull
    @Column(name = "Degree")
    private Degree degree;

    @ManyToMany(mappedBy = "professors")
    @ToString.Exclude
    private Collection<Course> courses = new ArrayList<Course>();

    public Professor(String name, String surname, Degree degree) {
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }


    public void addCourse(Course course) {
        if(!courses.contains(course))
            courses.add(course);
    }

    public void deleteCourse(Course course) {
        if(courses.contains(course))
            courses.remove(course);
    }

}