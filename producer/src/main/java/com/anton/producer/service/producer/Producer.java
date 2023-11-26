package com.anton.producer.service.producer;

import com.anton.producer.domain.WeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.observation.annotation.Observed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;




@Component
public class Producer {

    @Value("${topic.name}")
    private String weTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Observed(contextualName="send_post_message_weather_producer")
    public String sendMessage(WeatherData weatherData) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(weatherData);
        kafkaTemplate.send(weTopic, orderAsMessage);

        return "message sent";
    }
}
