package org.twspring.exercisejparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    @NotBlank(message = "Name cannot be blank or empty")
    @Size(min = 4, max = 25,
            message = "Name must have between 4 to 25 letters")
    @Pattern(regexp = "^[A-Za-z]+$",
            message = "Name must have only alphabetic characters")
    private String name;

    @Column(columnDefinition = "INT NOT NULL")
    @NotNull(message = "Age cannot be null")
    @Positive(message = "Age must be a positive number and not a zero")
    private Integer age;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    @NotBlank
    @Size(min = 7, max = 30,
            message = "Email must have between 7 to 30 letters")
    @Email(message = "Invalid email format")
    private String email;

    @Column(columnDefinition = "INT NOT NULL")
    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be a positive number and not a zero")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;
}
