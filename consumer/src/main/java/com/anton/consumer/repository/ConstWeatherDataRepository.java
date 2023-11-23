package com.anton.consumer.repository;

import com.anton.consumer.domain.ConstWeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstWeatherDataRepository extends JpaRepository<ConstWeatherData, Long> {
}
