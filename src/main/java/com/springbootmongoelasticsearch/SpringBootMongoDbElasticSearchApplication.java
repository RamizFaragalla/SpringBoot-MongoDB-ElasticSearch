package com.springbootmongoelasticsearch;

import com.springbootmongoelasticsearch.models.PersonModel;
import com.springbootmongoelasticsearch.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringBootMongoDbElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoDbElasticSearchApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PersonRepository repository) {
        String email = "john.doe@gmail.com";
        return args -> {
            PersonModel personModel = new PersonModel(
                    new Date(), new Date(), null, "John", "Doe",
                    email
            );

            repository.findPersonByEmail(email)
                    .ifPresentOrElse( p -> {
                        System.out.println(p + " already exists");
                    }, () -> {
                        System.out.println("Inserting person" + personModel);
                        repository.insert(personModel);
                    }
            );
        };
    }
}
