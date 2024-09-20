package com.springbootmongoelasticsearch.controllers;

import com.springbootmongoelasticsearch.dtos.PersonDto;
import com.springbootmongoelasticsearch.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> get(
        @PageableDefault(
            page = 0,
            size = Integer.MAX_VALUE,
            sort = "updatedAt",
            direction = Sort.Direction.DESC
        )
        Pageable pageable
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.get(pageable));
    }
}
