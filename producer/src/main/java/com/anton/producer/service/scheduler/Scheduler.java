package com.anton.producer.service.scheduler;

import com.anton.producer.domain.WeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Map;
import java.util.Random;



@Component
public class Scheduler {

    private final Random random;
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.name}")
    private String orderTopic;
    private final ObjectMapper objectMapper;
    private Long count1 = 0L;
    private Long count2 = 0L;


    @Autowired
    public Scheduler(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper,Random r) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.random=r;
    }

    @Scheduled(fixedRate = 1000)
    @Observed(contextualName="scheduled_send_weather_data")
    public void sendMessage() throws JsonProcessingException {
        count1++;
        String dataAsMessage = objectMapper.writeValueAsString(Map.of(
                    "vars","val" + count1,
                    "zar", "zar" +count1,
                        "vd",String.valueOf(random.nextExponential())
        ));
        kafkaTemplate.send("t.const.weather", dataAsMessage);
    }

    @Scheduled(fixedRate = 2000)
    @Observed(contextualName="scheduled_send_weather_data_two")
    public void sendMessageTwo() throws JsonProcessingException {
        count1++;
        String dataAsMessage = objectMapper.writeValueAsString(Map.of(
                    "vars","val" +random.nextLong(count1),
                    "zar", "zar" +random.nextLong(count1),
                        "vd",String.valueOf(random.nextExponential())
        ));
        kafkaTemplate.send("t.const.weather", dataAsMessage);
    }

    @Scheduled(fixedRate = 3000)
    @Observed(contextualName="scheduled_send_weather_data_three")
    public void sendMessageThree() throws JsonProcessingException {
        count1++;
        String dataAsMessage = objectMapper.writeValueAsString(Map.of(
                    "vars","val" +random.nextLong(count1)*random.nextDouble(),
                    "zar", "zar" +random.nextLong(count1)*3,
                        "vd",String.valueOf(random.nextExponential())
        ));
        kafkaTemplate.send("t.const.weather", dataAsMessage);
    }

    @Scheduled(fixedRate = 1000)
    @Observed(contextualName="send_message_wea_t")
    public void sendMessageWea() throws JsonProcessingException {
        count2++;
        String dataAsMessage = objectMapper.writeValueAsString(new WeatherData(
            "dfggdg" + count2,
            new Date(System.currentTimeMillis()),
            90.467 + count2,
            90.8 + count2,
            "ghadjs" + count2
        ));
        kafkaTemplate.send(orderTopic, dataAsMessage);
    }

    @Scheduled(fixedRate = 2000)
    @Observed(contextualName="send_message_wea_t2")
    public void sendMessageWeaTwo() throws JsonProcessingException {
        count2++;
        String dataAsMessage = objectMapper.writeValueAsString(new WeatherData(
            "wewqg" + count2,
            new Date(System.currentTimeMillis()),
            4560.467 + count2,
            546.8 + count2,
            "wqewq" + count2
        ));
        kafkaTemplate.send(orderTopic, dataAsMessage);
    }

    @Scheduled(fixedRate = 3000)
    @Observed(contextualName="send_message_wea_t3")
    public void sendMessageWeaThree() throws JsonProcessingException {
        count2++;
        String dataAsMessage = objectMapper.writeValueAsString(new WeatherData(
            "hjwewqg" + count2,
            new Date(System.currentTimeMillis()),
            4780.467 + count2,
            523.8 + count2,
            "wqewq" + count2
        ));
        kafkaTemplate.send(orderTopic, dataAsMessage);
    }




}