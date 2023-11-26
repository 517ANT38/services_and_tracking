package com.anton.consumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.observation.annotation.Observed;

import com.anton.consumer.domain.dto.ConstWeatherDataDto;
import com.anton.consumer.domain.dto.WeatherDataDto;
import com.anton.consumer.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final WeatherService weatherService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, WeatherService weatherService) {
        this.objectMapper = objectMapper;
        this.weatherService = weatherService;
    }

    @KafkaListener(topics = orderTopic)
    @Observed(contextualName = "wd_consumer")
    public void consumeMessage1(String message) throws JsonProcessingException {
        WeatherDataDto weatherDataDto = objectMapper.readValue(message, WeatherDataDto.class);
        weatherService.persistWeatherData(weatherDataDto);
    }

    @KafkaListener(topics = "t.const.weather")
    @Observed(contextualName = "const_wd_consumer")
    public void consumeMessage2(String message) throws JsonProcessingException {
        var weatherDataDto = objectMapper.readValue(message, ConstWeatherDataDto.class);
        weatherService.persistConstWeatherData(weatherDataDto);
    }
}
