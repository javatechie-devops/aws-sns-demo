package com.javatechie;

import com.javatechie.dto.MessageEvents;
import com.javatechie.service.SnsDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/sns")
public class AwsSnsApplication {

    @Autowired
    private SnsDemoService service;

    @GetMapping("/subscribe")
    public String enableSubscription(@RequestParam String protocol, @RequestParam String endpoint) {
        return service.autoSubscription(protocol, endpoint);
    }

    @PostMapping
    public String publishMessageToTopic(@RequestBody MessageEvents events) {
        return service.publishMessage(events.getEvent());
    }


    public static void main(String[] args) {
        SpringApplication.run(AwsSnsApplication.class, args);
    }

}
