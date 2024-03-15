package com.javatechie.producer;

import com.javatechie.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventPublisher {


    @Value("${spring.pulsar.producer.topic-name1}")
    private String topicName1;

    @Value("${spring.pulsar.producer.topic-name2}")
    private String topicName2;

    @Autowired
    private PulsarTemplate<Object> template;

    public void publishPlainMessage(String message) throws PulsarClientException {
        template.send(topicName1, message);
        log.info("EventPublisher::publishPlainMessage publish the event {}", message);
    }


    public void publishRawMessage(Customer customer) throws PulsarClientException {
        template.send(topicName2, customer);
        log.info("EventPublisher::publishRawMessage publish the event {}", customer.getName());
    }
}
