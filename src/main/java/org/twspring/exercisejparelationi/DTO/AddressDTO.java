package org.twspring.exercisejparelationi.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @Id
    private Integer teacher_id;

    @NotBlank(message = "Building number cannot be blank or empty")
    @Size(min = 4, max = 15,
            message = "Building number must be between 4 to 15 characters")
    private String buildingNumber; //String because we won't apply any mathematical operations

    @NotBlank(message = "Street cannot be blank or empty")
    @Size(min = 4, max = 25,
            message = "Street must be between 4 to 15 characters")
    private String street;

    @NotBlank(message = "Area cannot be blank or empty")
    @Size(min = 4, max = 25,
            message = "Area  must be between 4 to 15 characters")
    private String area;
}
