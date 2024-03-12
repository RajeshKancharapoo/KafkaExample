package com.example.kafkaexample.service;

import com.example.kafkaexample.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * KafkaProducerService is a service class that sends messages to Kafka topics.
 */
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    // KafkaTemplate for String messages.
    private final KafkaTemplate<String, String> kafkaTemplate;

    // KafkaTemplate for Student messages.
    private final KafkaTemplate<String, Student> studentKafkaTemplate;

    /**
     * This method sends a String message to the Kafka topic "string-topic".
     * @param message The message to be sent to the Kafka topic.
     */
    public void sendMessage(String message) {
        kafkaTemplate.send("string-topic", message);
    }

    /**
     * This method sends a Student message to the Kafka topic "student-topic".
     * @param student The Student message to be sent to the Kafka topic.
     */
    public void sendStudentMessage(Student student) {
        studentKafkaTemplate.send("student-topic", student);
    }
}