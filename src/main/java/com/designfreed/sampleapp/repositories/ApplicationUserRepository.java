package com.designfreed.sampleapp.repositories;

import com.designfreed.sampleapp.domain.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
    ApplicationUser findByUsername(String username);
}
