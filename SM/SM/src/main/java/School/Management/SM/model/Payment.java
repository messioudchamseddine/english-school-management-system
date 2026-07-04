package School.Management.SM.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}