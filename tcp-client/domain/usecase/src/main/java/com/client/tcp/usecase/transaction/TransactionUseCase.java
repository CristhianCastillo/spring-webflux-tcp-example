package com.client.tcp.usecase.transaction;

import com.client.tcp.model.transaction.gateways.TransactionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TransactionUseCase {

    private final TransactionRepository transactionRepository;

    public Mono<String> send(String transaction) {
        return this.transactionRepository.send(transaction);
    }
}
