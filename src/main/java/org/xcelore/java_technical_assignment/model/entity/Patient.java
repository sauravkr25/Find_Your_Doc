package org.xcelore.java_technical_assignment.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.xcelore.java_technical_assignment.model.enums.City;
import org.xcelore.java_technical_assignment.model.enums.Speciality;
import org.xcelore.java_technical_assignment.model.enums.Symptom;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name should contain at least 3 characters")
    private String name;

    @NotBlank(message = "City is required")
    @Size(max = 20, message = "City should contain at max 20 characters")
    private String city;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(min = 10, message = "Phone number should contain at least 10 digits")
    @Column(unique = true, nullable = false)
    private String phoneNo;

    @NotNull(message = "Symptom is required")
    @Enumerated(value = EnumType.STRING)
    private Symptom symptom;
}
