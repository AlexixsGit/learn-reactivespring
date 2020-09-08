package com.learnreactivespring.learnreactivespring.handler;

import com.learnreactivespring.learnreactivespring.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CalculatorHandler {

    private final CalculatorService calculatorService;

    public Mono<ServerResponse> sum(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.calculatorService.sum(serverRequest.queryParam("value1").get(),
                        serverRequest.queryParam("value2").get()), Double.class);
    }

    public Mono<ServerResponse> multiply(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.calculatorService.multiply(serverRequest.queryParam("value1").get(),
                        serverRequest.queryParam("value2").get()), Double.class);
    }
}
