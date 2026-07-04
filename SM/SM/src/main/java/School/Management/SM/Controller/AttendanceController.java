package School.Management.SM.Controller;

import School.Management.SM.model.Attendance;
import School.Management.SM.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendances")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceRepository repository;

    @GetMapping
    public List<Attendance> getAllAttendances() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Attendance> getAttendanceById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return repository.save(attendance);
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id,
                                       @RequestBody Attendance attendance) {
        attendance.setId(id);
        return repository.save(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        repository.deleteById(id);
    }
}