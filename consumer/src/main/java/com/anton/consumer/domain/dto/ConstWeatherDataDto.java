package com.anton.consumer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstWeatherDataDto {
    private String vars;
    private String zar;
    private String vd;
}
