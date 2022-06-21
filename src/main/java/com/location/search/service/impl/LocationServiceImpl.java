package com.location.search.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.location.search.constant.SearchConstant;
import com.location.search.dto.Location;
import com.location.search.dto.LocationData;
import com.location.search.dto.PositionStackResponse;
import com.location.search.repository.LocationRepository;
import com.location.search.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<LocationData> getSearchResults(String searchString) {
		PositionStackResponse response = restTemplate
				.getForObject(SearchConstant.POSITION_STACK_URL + "&query=" + searchString, 
						PositionStackResponse.class);
		if(Objects.nonNull(response)) {
			return response.getData();
		}
		return new ArrayList<>();
	}
	
	@Override
	@Transactional
	public void saveSearchString(List<String> request) {
		List<Location> locations = new ArrayList<>();
		if(Objects.nonNull(request) 
				&& !CollectionUtils.isEmpty(request)) {
			locations = request
					.stream()
					.map(req -> 
						new Location(UUID.randomUUID().toString(), req))
					.collect(Collectors.toList());
		}
		locationRepository.saveAll(locations);
	}
	
	@Override
	public List<String> getSearchString() {
		List<Location> results = locationRepository.findAll();
		if(Objects.nonNull(results) 
				&& !CollectionUtils.isEmpty(results)) {
			return results.stream().map(result -> result.getSearch()).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

}
