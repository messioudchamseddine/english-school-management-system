package School.Management.SM.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String message;

    private LocalDateTime sentAt;

    private boolean read;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}