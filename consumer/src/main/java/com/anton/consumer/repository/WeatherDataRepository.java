package com.anton.consumer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anton.consumer.domain.WeatherData;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    @Query("select w from WeatherData w where w.tempr <= :t")
    List<WeatherData> findByTempr(@Param("t") Double t);

    @Query("select w from WeatherData w where w.spendWinter <= :s")
    List<WeatherData> findBySpendWinter(@Param("s") Double s);


}
