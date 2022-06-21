package com.location.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.location.search.dto.LocationData;
import com.location.search.service.LocationService;

@RestController
@RequestMapping("locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/results")
	public List<LocationData> getSearchResults(@RequestParam(name = "searchString") String searchString) {
		return locationService.getSearchResults(searchString);
	}
	
	@PostMapping("/search")
	public void saveSearchStrings(@RequestBody List<String> request) {
		locationService.saveSearchString(request);
	}
	
	@GetMapping("/search")
	public List<String> getSearchStrings() {
		return locationService.getSearchString();
	}

}
