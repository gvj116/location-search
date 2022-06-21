package com.location.search.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "locationIndex")
public class Location {

	@Id
    private String id;
	
	@Field(type = FieldType.Text, name = "search")
	private String search;
	
	public Location(String id, String search) {
		this.id = id;
		this.search = search;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
