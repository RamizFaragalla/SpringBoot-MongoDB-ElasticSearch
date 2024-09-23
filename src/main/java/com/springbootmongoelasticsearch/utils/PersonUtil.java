package com.springbootmongoelasticsearch.utils;

import com.springbootmongoelasticsearch.dtos.PersonDto;
import com.springbootmongoelasticsearch.models.elasticsearch.PersonElasticSearchModel;
import com.springbootmongoelasticsearch.models.mongo.PersonModel;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PersonUtil {

    public static PersonModel convertToModel(PersonDto personDto) {
        Date now = new Date();
        return new PersonModel(
                now, now, null, personDto.getFirstName(),
                personDto.getLastName(), personDto.getEmail()
        );
    }

    public static PersonElasticSearchModel convertToElasticSearchModel(PersonDto personDto) {
        Date now = new Date();
        return new PersonElasticSearchModel(
                now, now, null, personDto.getFirstName(),
                personDto.getLastName(), personDto.getEmail()
        );
    }

    public static PersonDto convertToDto(PersonModel personModel) {
        return new PersonDto(
                personModel.getId(), personModel.getCreatedAt(), personModel.getUpdatedAt(), personModel.getArchivedAt(),
                personModel.getFirstName(), personModel.getLastName(), personModel.getEmail()
        );
    }

    public static List<PersonDto> convertToDtos(List<PersonModel> personModels) {
        return personModels.stream().map(PersonUtil::convertToDto).collect(Collectors.toList());
    }
}
