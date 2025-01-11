package com.healthconnection.infrastructure.adapters.messaging.service;

import com.healthconnection.infrastructure.adapters.messaging.MessageEvent;
import com.healthconnection.domain.ports.input.MessageSender;
import com.healthconnection.shared.helper.gson.MapperJsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RabbitMQAdapter implements MessageSender<Object> {

    private final RabbitTemplate rabbitTemplate;
    private final MapperJsonObject mapperJsonObject;


    private MessageProperties getMessageProperties(UUID idMessage) {
        return MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setHeader("idMessage",String.valueOf(idMessage))
                .build();
    }

    private Optional<Message> getMessage(Object message, MessageProperties messageProperties) {
        Optional<String> messageText = mapperJsonObject.executeGson(message);

        return messageText.map(mg -> MessageBuilder.withBody(mg.getBytes())
                .andProperties(messageProperties)
                .build());
    }

    @Override
    public void execute(Object message, UUID messageId, String exchange, String routingKey, String event) {

        MessageProperties messageProperties = getMessageProperties(messageId);
        Optional<String> messageJson = mapperJsonObject.executeGson(message);
        MessageEvent finalMessage = new MessageEvent(event,"");

        messageJson.ifPresent(finalMessage::setMessage);

        Optional<Message> messageOptional = getMessage(finalMessage, messageProperties);

        messageOptional.ifPresent(msg -> rabbitTemplate.convertAndSend(exchange, routingKey, msg));
    }
}
