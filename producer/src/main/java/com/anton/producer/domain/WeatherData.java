package com.anton.producer.domain;

import lombok.Data;
import lombok.Value;

import java.util.Date;

@Data
@Value
public class WeatherData {
    String desd;
    Date date;
    Double tempr;
    Double spendWinter;
    String item;
}
