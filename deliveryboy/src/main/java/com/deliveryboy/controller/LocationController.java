/**
 * 
 */
package com.deliveryboy.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.service.KafkaService;

import lombok.extern.slf4j.Slf4j;

/**
 * com.deliveryboy.controller DelL
 */
@RestController
@RequestMapping("/location")
@Slf4j
public class LocationController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?>updatelocation()
	{
		
		for (int i = 0; i <= 200; i++) {
			String location = "(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")";
			kafkaService.updatelocation(location);
			log.info("Iteration {}: Generated location {}", i, location);
		}
		log.info("All location updates sent to Kafka successfully");
				log.info("location update sent to kafka successfully");
		// Create a mutable map and wrap it with Collections.unmodifiableMap
		Map<String, String> responseMap = new HashMap<>();
		responseMap.put("message", "location update");
		Map<String, String> unmodifiableMap = Collections.unmodifiableMap(responseMap);

		return new ResponseEntity<>(unmodifiableMap, HttpStatus.OK);
	}
}
