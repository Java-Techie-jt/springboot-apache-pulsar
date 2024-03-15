package com.javatechie.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.common.schema.SchemaType;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventConsumer {


    @PulsarListener(
            topics = "${spring.pulsar.producer.topic-name1}",
            subscriptionName = "my-subscription",
            subscriptionType = SubscriptionType.Shared
    )
    public void consumeTextEvent(String msg) {
        log.info("EventConsumer:: consumeTextEvent consumed events {}", msg);
    }


    @PulsarListener(
            topics = "${spring.pulsar.producer.topic-name2}",
            subscriptionName = "my-subscription",
            schemaType = SchemaType.JSON,
            subscriptionType = SubscriptionType.Shared
    )
    public void consumeRawEvent(Customer customer) throws JsonProcessingException {
        log.info("EventConsumer:: consumeTextEvent consumed events {}", new ObjectMapper().writeValueAsString(customer));
    }
}
