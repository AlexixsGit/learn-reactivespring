package com.learnreactivespring.learnreactivespring.router;

import com.learnreactivespring.learnreactivespring.handler.CalculatorHandler;
import com.learnreactivespring.learnreactivespring.handler.MainHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> route(MainHandler mainHandler) {
        return RouterFunctions.route(GET("/functional/flux")
                .and(accept(MediaType.APPLICATION_JSON)), mainHandler::flux)
                .andRoute(GET("/functional/mono")
                        .and(accept(MediaType.APPLICATION_JSON)), mainHandler::mono);
    }

    @Bean
    public RouterFunction<ServerResponse> calculatorRoute(CalculatorHandler calculatorHandler) {
        return RouterFunctions.route(GET("/functional/calculator/sum")
                .and(accept(MediaType.APPLICATION_JSON)), calculatorHandler::sum)
                .andRoute(GET("/functional/calculator/multiply").and(accept(MediaType.APPLICATION_JSON)),
                        calculatorHandler::multiply);
    }

}
