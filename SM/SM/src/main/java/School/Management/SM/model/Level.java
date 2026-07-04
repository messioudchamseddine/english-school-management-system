package School.Management.SM.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name; // A1, A2, B1, B2, C1, C2

    private String description;

    @OneToMany(mappedBy = "level")
    private List<Group> groups;
}