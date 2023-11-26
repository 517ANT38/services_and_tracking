package com.anton.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

@Data
@Value
@AllArgsConstructor
public class WeatherData {
    private String desd;
    private Date date;
    private Double tempr;
    private Double spendWinter;
    private String item;
}
