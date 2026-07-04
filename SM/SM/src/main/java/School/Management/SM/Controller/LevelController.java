package School.Management.SM.Controller;

import School.Management.SM.model.Level;
import School.Management.SM.Repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/levels")
@CrossOrigin(origins = "*")
public class LevelController {

    @Autowired
    private LevelRepository repository;

    @GetMapping
    public List<Level> getAllLevels() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Level> getLevelById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Level addLevel(@RequestBody Level level) {
        return repository.save(level);
    }

    @PutMapping("/{id}")
    public Level updateLevel(@PathVariable Long id,
                             @RequestBody Level level) {

        level.setId(id);
        return repository.save(level);
    }

    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable Long id) {
        repository.deleteById(id);
    }
}