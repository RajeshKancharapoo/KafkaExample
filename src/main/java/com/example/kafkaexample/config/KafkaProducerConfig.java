package com.example.kafkaexample.config;

import com.example.kafkaexample.entity.Student;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * KafkaProducerConfig is a configuration class that sets up the Kafka producer factories and templates.
 */
@Configuration
public class KafkaProducerConfig {

    /**
     * This method sets up a ProducerFactory for String messages.
     * @return A ProducerFactory for String messages.
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    /**
     * This method sets up a ProducerFactory for Student messages.
     * @return A ProducerFactory for Student messages.
     */
    @Bean
    public ProducerFactory<String, Student> studentProducerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    /**
     * This method sets up a KafkaTemplate for String messages.
     * @return A KafkaTemplate for String messages.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    /**
     * This method sets up a KafkaTemplate for Student messages.
     * @return A KafkaTemplate for Student messages.
     */
    @Bean
    public KafkaTemplate<String, Student> studentKafkaTemplate() {
        return new KafkaTemplate<>(studentProducerFactory());
    }
}