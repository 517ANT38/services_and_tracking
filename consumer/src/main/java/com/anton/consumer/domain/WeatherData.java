package com.anton.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desd;
    private Date date;
    private Double tempr;
    private Double spendWinter;
    private String item;
}
