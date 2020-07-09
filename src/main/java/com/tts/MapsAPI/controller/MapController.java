package com.tts.MapsAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sun.scenario.effect.Blend.Mode;
import com.tts.MapsAPI.model.Location;
import com.tts.MapsAPI.service.MapsService;

@Controller
public class MapController {
	@Autowired
	private MapsService mapService;
	
	@GetMapping(value = {"/", "/home"})
	public String getDefaultMap(Model model) {
		model.addAttribute("location", new Location());
		return "index.html";
	}
	
	@PostMapping(value = {"/", "/home"})
	public String getMapForLocation(Location location, Model model) {
		mapService.addCoordinates(location);
		model.addAttribute("location", location);
		return "index.html";
	}
	@PostMapping(value = {"/", "/reverse"})
	public String getMapForCoords(Location location, Model model) {
		mapService.convertCoordinates(location);
		model.addAttribute("location", location);
		return "index.html";
	}
	@PostMapping(value = {"/", "/random"})
	public String getMapRandom(Location location, Model model) {
		mapService.randomCoordinates(location);
		model.addAttribute("location", location);
		return "index.html";
	}
}
