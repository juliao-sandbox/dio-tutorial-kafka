package me.dio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.dio.data.OrderData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SaveOrderService {

    @KafkaListener(topics = "SaveOrder", groupId = "MicroServiceSaveOrder")
    private void run(ConsumerRecord<String, String> record) {
        log.info("Key = {}", record.key());
        log.info("Header = {}", record.headers());
        log.info("Partition = {}", record.partition());

        String strData = record.value();

        ObjectMapper mapper = new ObjectMapper();
        OrderData order;

        try {
            order = mapper.readValue(strData, OrderData.class);
        } catch (JsonProcessingException e) {
            log.error("Error while converting event [data={}]", strData, e);
            return;
        }

        log.info("Event received = {}", order);
    }
}
