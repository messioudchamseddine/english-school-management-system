package School.Management.SM.Controller;

import School.Management.SM.model.Teacher;
import School.Management.SM.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = "*")
public class TeacherController {

    @Autowired
    private TeacherRepository repository;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return repository.save(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id,
                                 @RequestBody Teacher teacher) {

        teacher.setId(id);
        return repository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        repository.deleteById(id);
    }
}