package com.anton.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.micrometer.observation.annotation.Observed;

import com.anton.producer.domain.WeatherData;
import com.anton.producer.service.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherService {

    private final Producer producer;

    @Autowired
    public WeatherService(Producer producer) {
        this.producer = producer;
    }
    
    @Observed(name="send_post_message_weather_data_service")
    public String createWeatherInfo(WeatherData weatherData) throws JsonProcessingException {
        return producer.sendMessage(weatherData);
    }
}
