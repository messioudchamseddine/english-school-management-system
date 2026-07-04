package School.Management.SM.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends User {

    @Column(unique = true)
    private String teacherCode;

    private String specialization;

    private LocalDate hireDate;

    private Double salary;
}