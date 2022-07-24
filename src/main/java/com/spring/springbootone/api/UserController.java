package com.spring.springbootone.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Data
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    final private UserService patientService;

    @GetMapping
    public ResponseEntity<String> getUserById() {

        Flux.fromStream(Stream.generate(() -> "String"))
                .delayElements(Duration.ofSeconds(1));

        final var user = patientService.getUserById("id");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody final PatientCreationDTO patientCreationDTO) {
        final var patient = patientService.createPatient(patientCreationDTO);
        return ResponseEntity.ok(patient);
    }

}

class Patient {

}

class PatientCreationDTO {

}

@Service
class UserService {

    public String getUserById(final String id) {
        return "This is user";
    }

    public Patient createPatient(final PatientCreationDTO patientCreationDTO) {
        return new Patient();
    }
}