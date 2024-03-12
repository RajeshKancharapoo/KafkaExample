package com.example.kafkaexample.service;

import com.example.kafkaexample.entity.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * KafkaConsumerService is a service class that consumes messages from Kafka topics.
 */
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    /**
     * This method consumes String messages from the Kafka topic "string-topic".
     * @param message The message consumed from the Kafka topic.
     */
    @KafkaListener(topics = "string-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consumeStringMessage(String message) {
        System.out.println("Consumed message: " + message);
    }

    /**
     * This method consumes Student messages from the Kafka topic "student-topic".
     * @param student The Student message consumed from the Kafka topic.
     */
    @KafkaListener(topics = "student-topic", groupId = "group_id", containerFactory = "studentKafkaListenerContainerFactory")
    public void consumeStudentMessage(Student student) {
        System.out.println("Consumed student message: " + student);
    }
}