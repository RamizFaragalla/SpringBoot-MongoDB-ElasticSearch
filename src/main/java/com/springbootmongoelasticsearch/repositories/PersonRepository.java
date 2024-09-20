package com.springbootmongoelasticsearch.repositories;

import com.springbootmongoelasticsearch.models.PersonModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<PersonModel, String> {
    Optional<PersonModel> findPersonByEmail(String email);
}
