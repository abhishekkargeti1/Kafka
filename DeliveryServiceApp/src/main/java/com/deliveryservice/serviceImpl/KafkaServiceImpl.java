package com.deliveryservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryservice.config.AppConstant;
import com.deliveryservice.service.KafkaService;

@Service
public class KafkaServiceImpl implements KafkaService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	private Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

	KafkaServiceImpl(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public boolean updateLocation(String location) {
		// TODO Auto-generated method stub

		this.kafkaTemplate.send(AppConstant.Location_TOPIC_NAME, location);
		logger.info("Location Updated");
		return true;
	}

}
