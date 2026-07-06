package com.deliveryservice.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryservice.service.KafkaService;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

	@Autowired
	private KafkaService kafkaService;
	
	
	@PostMapping("/location")
	public ResponseEntity<?> updateLocation(){
		
		this.kafkaService.updateLocation("("+Math.round(Math.random()*100)+","+Math.round(Math.random()*100)+")");
		
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Location Updated"));
	}
	
}
