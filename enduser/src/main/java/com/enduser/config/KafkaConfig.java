/**
 * 
 */
package com.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.enduser.constants.AppConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * com.enduser.config
 *DelL
 */
@Configuration
@Slf4j
public class KafkaConfig {
	
	@KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC,groupId = AppConstants.GROUP_ID)
	public void updatedLocation(String value) {
		log.info("Received location update from Kafka: {}", value);
	}
}
