package com.springbootmongoelasticsearch.repositories.elasticsearch;

import com.springbootmongoelasticsearch.models.elasticsearch.PersonElasticSearchModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonElasticSearchRepository extends ElasticsearchRepository<PersonElasticSearchModel, String> {
}
