package School.Management.SM.Controller;

import School.Management.SM.model.Notification;
import School.Management.SM.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private NotificationRepository repository;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Notification> getNotificationById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Notification addNotification(@RequestBody Notification notification) {
        return repository.save(notification);
    }

    @PutMapping("/{id}")
    public Notification updateNotification(@PathVariable Long id,
                                           @RequestBody Notification notification) {
        notification.setId(id);
        return repository.save(notification);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        repository.deleteById(id);
    }
}