package com.springbootmongoelasticsearch.services.impl;

import com.springbootmongoelasticsearch.dtos.PersonDto;
import com.springbootmongoelasticsearch.exceptions.AppException;
import com.springbootmongoelasticsearch.models.elasticsearch.PersonElasticSearchModel;
import com.springbootmongoelasticsearch.models.mongo.PersonModel;
import com.springbootmongoelasticsearch.repositories.elasticsearch.PersonElasticSearchRepository;
import com.springbootmongoelasticsearch.repositories.mongo.PersonRepository;
import com.springbootmongoelasticsearch.services.PersonService;
import com.springbootmongoelasticsearch.utils.PersonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonElasticSearchRepository personElasticSearchRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonElasticSearchRepository personElasticSearchRepository) {
        this.personRepository = personRepository;
        this.personElasticSearchRepository = personElasticSearchRepository;
    }

    @Override
    public PersonDto create(PersonDto personDto) {
        if (personRepository.findPersonByEmail(personDto.getEmail()).isPresent()) {
            throw new AppException(
                    "Person with email " + personDto.getEmail() + " already exists",
                    HttpStatus.BAD_REQUEST
            );
        } else {
            PersonModel personModel = personRepository.insert(PersonUtil.convertToModel(personDto));
            personElasticSearchRepository.save(PersonUtil.convertToElasticSearchModel(personDto));

            return PersonUtil.convertToDto(personModel);
        }
    }

    @Override
    public List<PersonDto> get(Pageable pageable) {
        return PersonUtil.convertToDtos(personRepository.findAll(pageable).toList());
    }
}
