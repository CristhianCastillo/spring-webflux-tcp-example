package com.client.tcp.api;

import com.client.tcp.api.request.RequestMessage;
import com.client.tcp.api.response.GenericResponse;
import com.client.tcp.api.response.ResponseMessage;
import com.client.tcp.usecase.transaction.TransactionUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final TransactionUseCase transactionUseCase;

    @PostMapping(path = "/transaction")
    public Mono<ResponseEntity<GenericResponse<ResponseMessage>>> sendTransaction(@Valid @RequestBody RequestMessage requestMessage) {
        return this.transactionUseCase.send(requestMessage.getMessage())
                .map(response -> new ResponseEntity<>(GenericResponse.success(new ResponseMessage(response)), HttpStatus.OK));
    }
}
