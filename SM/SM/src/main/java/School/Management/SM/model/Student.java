package School.Management.SM.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {

    @Column(unique = true)
    private String studentCode;

    private LocalDate birthDate;

    private LocalDate registrationDate;
}