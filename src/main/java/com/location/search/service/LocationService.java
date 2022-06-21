package com.location.search.service;

import java.util.List;

import com.location.search.dto.LocationData;

public interface LocationService {

	List<LocationData> getSearchResults(String searchString);

	void saveSearchString(List<String> request);

	List<String> getSearchString();

}
