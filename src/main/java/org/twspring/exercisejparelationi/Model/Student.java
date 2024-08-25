package org.twspring.exercisejparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 4, max = 25, message = "Name must have between 4 to 25 characters")
    private String name;

    @Column(columnDefinition = "INT NOT NULL")
    @Positive(message = "Age cannot be a zero or a negative number")
    @NotNull(message = "Age cannot be null")
    private Integer age;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    @NotEmpty(message = "Major cannot be empty")
    @Size(min = 4, max = 25, message = "Major must have between 4 to 25 characters")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
