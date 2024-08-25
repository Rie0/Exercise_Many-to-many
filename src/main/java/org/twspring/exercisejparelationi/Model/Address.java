package org.twspring.exercisejparelationi.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "VARCHAR(15) NOT NULL UNIQUE")
    private String buildingNumber; //String because we won't apply any mathematical operations

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String street;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String area;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
