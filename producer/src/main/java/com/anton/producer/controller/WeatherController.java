package com.anton.producer.controller;

import com.anton.producer.domain.WeatherData;
import com.anton.producer.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping
    @Observed(name="send_post_message_weather_data")
    public String createFoodOrder(@RequestBody WeatherData weatherData) throws JsonProcessingException {
       return weatherService.createWeatherInfo(weatherData);
    }
}
