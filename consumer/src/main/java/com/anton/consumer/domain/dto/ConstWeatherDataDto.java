package com.anton.consumer.domain.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class ConstWeatherDataDto {
    private String vars;
    private String zar;
    private String vd;
}
