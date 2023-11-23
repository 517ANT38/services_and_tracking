package com.anton.consumer.domain.dto;

import lombok.Data;
import lombok.Value;

import java.util.Date;

@Data
@Value
public class WeatherDataDto {
    private String item;
    private String desd;
    private Date date;
    private Double tempr;
    private Double spendWinter;

}
