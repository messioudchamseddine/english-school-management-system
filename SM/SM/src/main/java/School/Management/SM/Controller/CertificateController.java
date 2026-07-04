package School.Management.SM.Controller;

import School.Management.SM.model.Certificate;
import School.Management.SM.Repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/certificates")
@CrossOrigin(origins = "*")
public class CertificateController {

    @Autowired
    private CertificateRepository repository;

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Certificate> getCertificateById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return repository.save(certificate);
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable Long id,
                                         @RequestBody Certificate certificate) {

        certificate.setId(id);
        return repository.save(certificate);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        repository.deleteById(id);
    }
}