package com.anton.consumer.repository;

import com.anton.consumer.domain.ConstWeatherData;
import com.anton.consumer.domain.WeatherData;

import io.micrometer.observation.annotation.Observed;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstWeatherDataRepository extends JpaRepository<ConstWeatherData, Long> {
    @Observed(contextualName = "findAll_trace")
    List<ConstWeatherData> findAll();

    @Observed(contextualName = "save_trace")
    ConstWeatherData save(ConstWeatherData c);
}
