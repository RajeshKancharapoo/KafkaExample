package com.example.kafkaexample.controller;

import com.example.kafkaexample.entity.Student;
import com.example.kafkaexample.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * KafkaController is a REST controller that provides endpoints for publishing messages to Kafka topics.
 */
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

    // KafkaProducerService is used to send messages to Kafka topics.
    private final KafkaProducerService kafkaProducerService;

    /**
     * This method is a POST endpoint that sends a message to a Kafka topic.
     * @param message The message to be sent to the Kafka topic.
     * @return A string indicating that the message was sent successfully.
     */
    @PostMapping("/publish")
    public String sendMessageToKafkaTopic(@RequestBody String message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent to the Kafka Topic string-topic Successfully";
    }

    /**
     * This method is a POST endpoint that sends a Student object as a message to a Kafka topic.
     * @param student The Student object to be sent to the Kafka topic.
     * @return A string indicating that the Student message was sent successfully.
     */
    @PostMapping("/publish/student")
    public String sendStudentMessageToKafkaTopic(@RequestBody Student student) {
        kafkaProducerService.sendStudentMessage(student);
        return "Student message sent to the Kafka Topic student-topic Successfully";
    }

}