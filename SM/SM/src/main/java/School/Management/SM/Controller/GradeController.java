package School.Management.SM.Controller;

import School.Management.SM.model.Grade;
import School.Management.SM.Repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
@CrossOrigin(origins = "*")
public class GradeController {

    @Autowired
    private GradeRepository repository;

    @GetMapping
    public List<Grade> getAllGrades() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Grade> getGradeById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Grade addGrade(@RequestBody Grade grade) {
        return repository.save(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id,
                             @RequestBody Grade grade) {
        grade.setId(id);
        return repository.save(grade);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        repository.deleteById(id);
    }
}