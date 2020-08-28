package com.learnreactivespring.learnreactivespring.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class MonoAndFluxTest {

    @Test
    public void get_items_from_flux_if_there_are_available_test() {

        Flux<String> animals = Flux.just("Dog", "Cat", "Duck", "Penguin", "Shark").
                concatWith(Flux.error(new RuntimeException("Runtime exception occurred"))).log();
        animals.subscribe(System.out::println, System.err::println);
    }

    @Test
    public void get_flux_elements_without_error_test() {

        Flux<String> fruits = Flux.just("Apple", "Pineapple", "Strawberry", "watermelon").log();

        StepVerifier.create(fruits)
                .expectNext("Apple")
                .expectNext("Pineapple")
                .expectNext("Strawberry")
                .expectNext("watermelon")
                .verifyComplete();
    }

    @Test
    public void get_flux_elements_with_error_test() {

        Flux<String> familyMembers = Flux.just("Father", "Mother", "Brother")
                .concatWith(Flux.error(new RuntimeException("Error occurred"))).log();

        StepVerifier.create(familyMembers)
                .expectNext("Father")
                .expectNext("Mother")
                .expectNext("Brother")
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    public void get_true_if_count_elements_is_3_test() {
        Flux<String> food = Flux.just("Rice", "Milk", "eggs")
                .concatWith(Flux.error(new RuntimeException("Error"))).log();

        StepVerifier.create(food)
                .expectNextCount(3)
                .expectErrorMessage("Error")
                .verify();
    }
}
