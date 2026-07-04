package School.Management.SM.Controller;

import School.Management.SM.model.Course;
import School.Management.SM.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @GetMapping
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return repository.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id,
                               @RequestBody Course course) {

        course.setId(id);
        return repository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        repository.deleteById(id);
    }
}