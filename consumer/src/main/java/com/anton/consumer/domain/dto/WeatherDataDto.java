package com.anton.consumer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDataDto {
    private String item;
    private String desd;
    private Date date;
    private Double tempr;
    private Double spendWinter;

    

}
