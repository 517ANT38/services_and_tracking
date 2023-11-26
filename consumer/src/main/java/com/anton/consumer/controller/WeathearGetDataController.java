package com.anton.consumer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anton.consumer.domain.dto.ConstWeatherDataDto;
import com.anton.consumer.domain.dto.WeatherDataDto;
import com.anton.consumer.service.WeatherService;

import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;

@RequestMapping("/getDataOrConstDataWeather")
@RestController
@AllArgsConstructor
public class WeathearGetDataController {
    
    private final WeatherService wService;

    @GetMapping("/data")
    public ResponseEntity<List<WeatherDataDto>> getDataAll(){
        return ResponseEntity.ok(wService.selecWeatherDataDtosBy());
    }
    @GetMapping("/constData")    
    public ResponseEntity<List<ConstWeatherDataDto>> getConstDataAll(){
        return ResponseEntity.ok(wService.selectConstWeatherDataDtos());
    }
    @GetMapping("/data/tempr/{t}")    
    public ResponseEntity<List<WeatherDataDto>> getDataByTempr(@PathVariable("t") Double t){
        return ResponseEntity.ok(wService.selecWeatherDataDtosByT(t));
    }
    @GetMapping("/data/spendWinter/{s}")    
    public ResponseEntity<List<WeatherDataDto>> getDataBySpendWinter(@PathVariable("s") Double s){
        return ResponseEntity.ok(wService.selecWeatherDataDtosByS(s));
    }

}
