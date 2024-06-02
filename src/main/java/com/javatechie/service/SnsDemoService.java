package com.javatechie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;
import software.amazon.awssdk.services.sns.model.SubscribeResponse;

@Service
public class SnsDemoService {

    public static final String TOPIC = "";

    @Autowired
    private SnsClient snsClient;

    public String autoSubscription(String protocol, String endpoint) {
        SubscribeRequest subscribeRequest = SubscribeRequest.builder()
                .topicArn(TOPIC)
                .protocol(protocol)
                .endpoint(endpoint)
                .build();
        SubscribeResponse subscribeResponse = snsClient.subscribe(subscribeRequest);
        return subscribeResponse.subscriptionArn();
    }

    public String publishMessage(String message) {
        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(TOPIC)
                .message(message)
                .build();
        PublishResponse publishResponse = snsClient.publish(publishRequest);
        return publishResponse.messageId();
    }

}
