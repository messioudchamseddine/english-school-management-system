package School.Management.SM.Controller;

import School.Management.SM.model.Enrollment;
import School.Management.SM.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository repository;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Enrollment> getEnrollmentById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Long id,
                                       @RequestBody Enrollment enrollment) {
        enrollment.setId(id);
        return repository.save(enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}