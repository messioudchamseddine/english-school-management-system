package School.Management.SM.Controller;

import School.Management.SM.model.Group;
import School.Management.SM.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    @Autowired
    private GroupRepository repository;

    @GetMapping
    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Group> getGroupById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Group addGroup(@RequestBody Group group) {
        return repository.save(group);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable Long id,
                             @RequestBody Group group) {

        group.setId(id);
        return repository.save(group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        repository.deleteById(id);
    }
}