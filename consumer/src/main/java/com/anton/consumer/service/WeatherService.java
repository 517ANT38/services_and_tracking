package com.anton.consumer.service;

import com.anton.consumer.repository.ConstWeatherDataRepository;
import com.anton.consumer.domain.ConstWeatherData;
import com.anton.consumer.domain.WeatherData;
import com.anton.consumer.domain.dto.ConstWeatherDataDto;
import com.anton.consumer.domain.dto.WeatherDataDto;
import com.anton.consumer.repository.WeatherDataRepository;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherService {

    private final WeatherDataRepository weatherDataRepository;
    private final ModelMapper modelMapper;

    private final ConstWeatherDataRepository constWeatherDataRepository;

    @Autowired
    public WeatherService(WeatherDataRepository weatherDataRepository, ModelMapper modelMapper, ConstWeatherDataRepository constWeatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
        this.modelMapper = modelMapper;
        this.constWeatherDataRepository = constWeatherDataRepository;
    }

    
    public void persistWeatherData(WeatherDataDto weatherDataDto) {
        WeatherData weatherData = modelMapper.map(weatherDataDto, WeatherData.class);
        WeatherData persistedWeatherData = weatherDataRepository.save(weatherData);


    }

    
    public void persistConstWeatherData(ConstWeatherDataDto constWeatherData) {
        ConstWeatherData weatherData = modelMapper.map(constWeatherData, ConstWeatherData.class);
        ConstWeatherData persistedWeatherData = constWeatherDataRepository.save(weatherData);


    }
}
