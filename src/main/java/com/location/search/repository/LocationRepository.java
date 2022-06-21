package com.location.search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.location.search.dto.Location;

public interface LocationRepository extends ElasticsearchRepository<Location, String> {
	
	List<Location> findAll();

}
