package lv.venta.spring_seminar_6.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {
    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idc")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idc;


    @NotNull
    @Size(min = 4, max = 50)
    @Pattern(regexp = "[A-Za-z :]+") //TODO nokopēt no iepriekšējiem semināriem arī ar mīkstinājumu/garumu zīmēm
    @Column(name = "Title")
    private String title;

    @Min(0)
    @Max(20)
    @Column(name = "Cp")
    private int cp;

    @OneToOne
    @JoinColumn(name = "Idp")//otras kalses Column nosaukums
    private Professor professor;

    @OneToMany(mappedBy = "course")//saite uz otras klases mainīgo
    @ToString.Exclude
    private Collection<Grade> grades;




    public Course(String title, int cp, Professor professor) {
        setTitle(title);
        setCp(cp);
        setProfessor(professor);
    }







}