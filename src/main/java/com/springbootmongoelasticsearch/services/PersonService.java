package com.springbootmongoelasticsearch.services;

import com.springbootmongoelasticsearch.dtos.PersonDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    PersonDto create(PersonDto personDto);
    List<PersonDto> get(Pageable pageable);
}
