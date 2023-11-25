package com.anton.producer.service.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;



@Component
public class Scheduler {

    private final Random random;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String orderTopic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private Integer count = 0;

    @Autowired
    public Scheduler(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper,Random r) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.random=r;
    }

    @Scheduled(fixedRate = 1000)
    @Observed(name="scheduled_send_weather_data")
    public void sendMessage() throws JsonProcessingException {
        count++;
        String dataAsMessage = objectMapper.writeValueAsString(Map.of(
                    "vars","val" + count,
                    "zar", "zar" +count,
                        "vd",String.valueOf(random.nextExponential())
        ));
        kafkaTemplate.send("t.const.weather", dataAsMessage);
    }

    @Scheduled(fixedRate = 2000)
    @Observed(name="scheduled_send_weather_data_two")
    public void sendMessageTwo() throws JsonProcessingException {
        count++;
        String dataAsMessage = objectMapper.writeValueAsString(Map.of(
                    "vars","val" +random.nextInt(count),
                    "zar", "zar" +random.nextInt(count),
                        "vd",String.valueOf(random.nextExponential())
        ));
        kafkaTemplate.send("t.const.weather", dataAsMessage);
    }

    @Scheduled(fixedRate = 3000)
    @Observed(name="scheduled_send_weather_data_three")
    public void sendMessageThree() throws JsonProcessingException {
        count++;
        String dataAsMessage = objectMapper.writeValueAsString(Map.of(
                    "vars","val" +random.nextInt(count)*random.nextDouble(),
                    "zar", "zar" +random.nextInt(count)*3,
                        "vd",String.valueOf(random.nextExponential())
        ));
        kafkaTemplate.send("t.const.weather", dataAsMessage);
    }




    

}