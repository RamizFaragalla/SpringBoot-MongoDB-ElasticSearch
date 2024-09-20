package com.springbootmongoelasticsearch.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springbootmongoelasticsearch.utils.DateUtil;
import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class PersonDto {
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.ISO)
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.ISO)
    private Date updatedAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.ISO)
    private Date archivedAt;
    private String firstName;
    private String lastName;
    private String email;

    public PersonDto(
            String id, Date createdAt, Date updatedAt, Date archivedAt,
            String firstName, String lastName, String email
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.archivedAt = archivedAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
