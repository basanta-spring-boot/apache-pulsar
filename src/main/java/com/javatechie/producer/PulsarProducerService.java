package com.javatechie.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PulsarProducerService {

    @Autowired
    private PulsarTemplate<String> pulsarTemplate;

    public void sendMessage(String message) throws PulsarClientException, JsonProcessingException {
        MessageId id = pulsarTemplate.send("my-topic", message);
        log.info("message published {}", new ObjectMapper().writeValueAsString(id));
    }
}
