package com.javatechie.controller;

import com.javatechie.dto.Customer;
import com.javatechie.producer.EventPublisher;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class EventController {


    @Autowired
    private EventPublisher publisher;

    @GetMapping("/text/{message}")
    public String sendTextEvent(@PathVariable String message) throws PulsarClientException {
        publisher.publishPlainMessage(message);
        return "message published !";
    }

    @PostMapping("/raw")
    public String sendRawEvent(@RequestBody Customer customer) throws PulsarClientException {
        publisher.publishRawMessage(customer);
        return "Custom object published !";
    }
}
