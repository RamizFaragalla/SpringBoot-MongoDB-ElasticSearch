package com.springbootmongoelasticsearch.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(value = "person")
public class PersonModel {
    @Id
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private Date archivedAt;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;

    public PersonModel(
            Date createdAt, Date updatedAt, Date archivedAt,
            String firstName, String lastName,
            String email
    ) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.archivedAt = archivedAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
