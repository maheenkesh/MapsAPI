package com.tts.MapsAPI.model;

import java.util.List;

public class GeocodingResponse {
    private List<Geocoding> results;
    
	public GeocodingResponse() {}

	public GeocodingResponse(List<Geocoding> results) {
		super();
		this.results = results;
	}

	public List<Geocoding> getResults() {
		return results;
	}

	public void setResults(List<Geocoding> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "GeocodingResponse [results=" + results + "]";
	}
	
	
}
