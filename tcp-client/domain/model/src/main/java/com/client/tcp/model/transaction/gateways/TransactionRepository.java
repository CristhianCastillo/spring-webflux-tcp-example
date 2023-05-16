package com.client.tcp.model.transaction.gateways;

import reactor.core.publisher.Mono;

public interface TransactionRepository {

    Mono<String> send(String message);
}
