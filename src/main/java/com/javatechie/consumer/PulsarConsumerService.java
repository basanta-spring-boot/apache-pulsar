package com.javatechie.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.stereotype.Service;
import org.springframework.pulsar.annotation.PulsarListener;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class PulsarConsumerService {

    @PulsarListener(
            subscriptionName = "my-subscription",
            topics = "my-topic",
            subscriptionType = SubscriptionType.Shared
    )
    public void onMessage(String message) {
        log.info("Received message: {} ", message);
        // Process the message as needed
    }
}
