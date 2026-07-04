package School.Management.SM.Controller;

import School.Management.SM.model.Classroom;
import School.Management.SM.Repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classrooms")
@CrossOrigin(origins = "*")
public class ClassroomController {

    @Autowired
    private ClassroomRepository repository;

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Classroom> getClassroomById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Classroom addClassroom(@RequestBody Classroom classroom) {
        return repository.save(classroom);
    }

    @PutMapping("/{id}")
    public Classroom updateClassroom(@PathVariable Long id,
                                     @RequestBody Classroom classroom) {
        classroom.setId(id);
        return repository.save(classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        repository.deleteById(id);
    }
}