package School.Management.SM.Controller;

import School.Management.SM.model.Schedule;
import School.Management.SM.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
@CrossOrigin(origins = "*")
public class ScheduleController {

    @Autowired
    private ScheduleRepository repository;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Schedule> getScheduleById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return repository.save(schedule);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Long id,
                                   @RequestBody Schedule schedule) {
        schedule.setId(id);
        return repository.save(schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        repository.deleteById(id);
    }
}