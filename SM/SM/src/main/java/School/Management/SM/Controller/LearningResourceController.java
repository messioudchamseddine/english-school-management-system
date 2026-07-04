package School.Management.SM.Controller;

import School.Management.SM.model.LearningResource;
import School.Management.SM.Repository.LearningResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "*")
public class LearningResourceController {

    @Autowired
    private LearningResourceRepository repository;

    @GetMapping
    public List<LearningResource> getAllResources() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LearningResource> getResourceById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public LearningResource addResource(@RequestBody LearningResource resource) {
        return repository.save(resource);
    }

    @PutMapping("/{id}")
    public LearningResource updateResource(@PathVariable Long id,
                                           @RequestBody LearningResource resource) {
        resource.setId(id);
        return repository.save(resource);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        repository.deleteById(id);
    }
}