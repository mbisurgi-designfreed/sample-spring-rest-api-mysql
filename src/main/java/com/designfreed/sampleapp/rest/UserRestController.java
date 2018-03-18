package com.designfreed.sampleapp.rest;

import com.designfreed.sampleapp.domain.ApplicationUser;
import com.designfreed.sampleapp.repositories.ApplicationUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/users")
public class UserRestController {
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRestController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Boolean> signUp(@RequestBody ApplicationUser user) {
        ResponseEntity<Boolean> response;

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        try {
            ApplicationUser newUser = applicationUserRepository.save(user);

            if (newUser != null) {
                response = ResponseEntity.ok(true);
            } else {
                response = ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            response = ResponseEntity.badRequest().build();
        }
        
        return response;
    }
}
