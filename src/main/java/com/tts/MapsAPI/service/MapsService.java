package com.tts.MapsAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tts.MapsAPI.model.GeocodingResponse;
import com.tts.MapsAPI.model.Location;

@Service
public class MapsService {
	@Value("${api_key}")
	private String apiKey;
	
	public void addCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
		location.getCity() + "," + location.getState() + "&key=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());
	}
	public void convertCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
		location.getCity() + "," + location.getState() + "&key=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setCity(coordinates.getCity());
		location.setState(coordinates.getState());
	}
	public void randomCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
		location.getCity() + "," + location.getState() + "&key=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		double latit = (Math.random()* 180.0)-90.0;
		location.setLat(Double.toString(latit));
		double longit = (Math.random()* 360.0)-180.0;
		location.setLng(Double.toString(longit));
		location.setCity(coordinates.getCity());
		location.setState(coordinates.getState());
	}
}
