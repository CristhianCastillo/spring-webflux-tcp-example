package com.server.tcp.tcp.endpoint;

import com.server.tcp.tcp.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
@AllArgsConstructor
public class ServerEndpoint {

    private final MessageService messageService;

    @ServiceActivator(inputChannel = "inboundChannel")
    public byte[] process(byte[] message) {
        return messageService.processMessage(message);
    }
}
