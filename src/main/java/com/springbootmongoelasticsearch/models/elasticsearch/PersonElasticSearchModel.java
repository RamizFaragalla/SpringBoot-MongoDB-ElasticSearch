package com.springbootmongoelasticsearch.models.elasticsearch;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "person")
public class PersonElasticSearchModel {
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private Date archivedAt;
    private String firstName;
    private String lastName;
    private String email;

    public PersonElasticSearchModel(
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
