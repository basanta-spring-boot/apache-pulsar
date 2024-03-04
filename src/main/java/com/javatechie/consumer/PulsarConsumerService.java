package com.javatechie.consumer;

import com.javatechie.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.common.schema.SchemaType;
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


    @PulsarListener(
            subscriptionName = "my-subscription",
            topics = "customer-topic",
            schemaType = SchemaType.JSON,
            subscriptionType = SubscriptionType.Shared
    )
    public void userTopicListener(Customer customer) {
        log.info("Received customer object with name : {}", customer.getName());
    }
}
