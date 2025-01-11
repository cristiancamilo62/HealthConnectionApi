package com.healthconnection.domain.ports.input;

import java.util.UUID;


public interface MessageSender<M> {

    void execute(M message, UUID messageId, String exchange, String routingKey, String event);

}
