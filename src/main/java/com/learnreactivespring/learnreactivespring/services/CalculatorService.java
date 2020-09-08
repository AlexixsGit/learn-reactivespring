package com.learnreactivespring.learnreactivespring.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CalculatorService {

    public Mono<Double> sum(String value1, String value2) {
        return Mono.just(Double.parseDouble(value1) + Double.parseDouble(value2));
    }

    public Mono<Double> multiply(String value1, String value2) {
        return Mono.just(Double.parseDouble(value1) * Double.parseDouble(value2));
    }

    public Mono<Double> divide(String value1, String value2) {
        return Mono.just(Double.parseDouble(value1) / Double.parseDouble(value2));
    }

    public Mono<Double> subtract(String value1, String value2) {
        return Mono.just(Double.parseDouble(value1) - Double.parseDouble(value2));
    }
}
