package School.Management.SM.Controller;

import School.Management.SM.model.Payment;
import School.Management.SM.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        return repository.save(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id,
                                 @RequestBody Payment payment) {
        payment.setId(id);
        return repository.save(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}