package com.healthconnection.infrastructure.adapters.messaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange patientExchange() {
        return new DirectExchange("patient.exchange");
    }

    @Bean
    public Queue patientQueue() {
        return new Queue("patient");
    }

    @Bean
    public Binding patientBinding(DirectExchange patientExchange, Queue patientQueue) {
        return BindingBuilder.bind(patientQueue)
                .to(patientExchange)
                .with("patient.create");
    }
}
