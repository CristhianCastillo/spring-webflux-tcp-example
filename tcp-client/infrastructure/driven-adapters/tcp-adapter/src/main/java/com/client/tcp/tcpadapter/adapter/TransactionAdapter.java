package com.client.tcp.tcpadapter.adapter;

import com.client.tcp.model.transaction.gateways.TransactionRepository;
import com.client.tcp.tcpadapter.gateway.TcpClientGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@AllArgsConstructor
public class TransactionAdapter implements TransactionRepository {

    private final TcpClientGateway tcpClientGateway;

    @Override
    public Mono<String> send(String message) {
        return Mono.fromCallable(() -> {
                    byte[] responseBytes = this.tcpClientGateway.send(message.getBytes());
                    return new String(responseBytes);
                }).doOnSubscribe(subscription -> log.info("Message request: {}", message))
                .doOnNext(response -> log.info("Message response: {}", response));
    }
}
