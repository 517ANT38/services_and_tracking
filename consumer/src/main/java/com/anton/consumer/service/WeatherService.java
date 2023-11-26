package com.anton.consumer.service;

import com.anton.consumer.repository.ConstWeatherDataRepository;
import com.anton.consumer.domain.ConstWeatherData;
import com.anton.consumer.domain.WeatherData;
import com.anton.consumer.domain.dto.ConstWeatherDataDto;
import com.anton.consumer.domain.dto.WeatherDataDto;
import com.anton.consumer.repository.WeatherDataRepository;

import java.util.List;

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
        ConstWeatherData weatherData = modelMapper.map(constWeatherData,ConstWeatherData.class);
        ConstWeatherData persistedWeatherData = constWeatherDataRepository.save(weatherData);


    }

    public List<ConstWeatherDataDto> selectConstWeatherDataDtos(){
        return constWeatherDataRepository.findAll().stream()
            .map(x -> modelMapper.map(x, ConstWeatherDataDto.class))
            .toList();
    }

    public List<WeatherDataDto> selecWeatherDataDtosBy(){
        return weatherDataRepository.findAll().stream()
            .map(x -> modelMapper.map(x, WeatherDataDto.class))
            .toList();
    }

    public List<WeatherDataDto> selecWeatherDataDtosByT(Double t){
        return weatherDataRepository.findByTempr(t).stream()
            .map(x -> modelMapper.map(x, WeatherDataDto.class))
            .toList();
    }

    public List<WeatherDataDto> selecWeatherDataDtosByS(Double s){
        return weatherDataRepository.findBySpendWinter(s).stream()
            .map(x -> modelMapper.map(x, WeatherDataDto.class))
            .toList();
    }
    
}
