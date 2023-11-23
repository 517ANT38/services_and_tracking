package com.anton.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    public String createWeatherInfo(WeatherData weatherData) throws JsonProcessingException {
        return producer.sendMessage(weatherData);
    }
}
