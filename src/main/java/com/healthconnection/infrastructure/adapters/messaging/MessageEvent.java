package com.healthconnection.infrastructure.adapters.messaging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEvent {

    private String message;
    private String Event;
}
