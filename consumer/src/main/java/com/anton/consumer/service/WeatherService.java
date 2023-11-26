package com.anton.consumer.service;

import com.anton.consumer.repository.ConstWeatherDataRepository;
import com.anton.consumer.domain.ConstWeatherData;
import com.anton.consumer.domain.WeatherData;
import com.anton.consumer.domain.dto.ConstWeatherDataDto;
import com.anton.consumer.domain.dto.WeatherDataDto;
import com.anton.consumer.repository.WeatherDataRepository;

import io.micrometer.observation.annotation.Observed;

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

    @Observed(contextualName = "wd_consumer_persist")
    public void persistWeatherData(WeatherDataDto weatherDataDto) {
        WeatherData weatherData = modelMapper.map(weatherDataDto, WeatherData.class);
        WeatherData persistedWeatherData = weatherDataRepository.save(weatherData);


    }

    @Observed(contextualName = "const_wd_consumer_persist")
    public void persistConstWeatherData(ConstWeatherDataDto constWeatherData) {
        ConstWeatherData weatherData = modelMapper.map(constWeatherData,ConstWeatherData.class);
        ConstWeatherData persistedWeatherData = constWeatherDataRepository.save(weatherData);


    }
    @Observed(contextualName = "const_weathear_data_get_all")
    public List<ConstWeatherDataDto> selectConstWeatherDataDtos(){
        return constWeatherDataRepository.findAll().stream()
            .map(x -> modelMapper.map(x, ConstWeatherDataDto.class))
            .toList();
    }

    @Observed(contextualName = "weathear_data_get_all")
    public List<WeatherDataDto> selecWeatherDataDtosBy(){
        return weatherDataRepository.findAll().stream()
            .map(x -> modelMapper.map(x, WeatherDataDto.class))
            .toList();
    }

    @Observed(contextualName = "weathear_data_get_all")
    public List<WeatherDataDto> selecWeatherDataDtosByT(Double t){
        return weatherDataRepository.findByTempr(t).stream()
            .map(x -> modelMapper.map(x, WeatherDataDto.class))
            .toList();
    }

    @Observed(contextualName = "weathear_data_get_all")
    public List<WeatherDataDto> selecWeatherDataDtosByS(Double s){
        return weatherDataRepository.findBySpendWinter(s).stream()
            .map(x -> modelMapper.map(x, WeatherDataDto.class))
            .toList();
    }
    
}
