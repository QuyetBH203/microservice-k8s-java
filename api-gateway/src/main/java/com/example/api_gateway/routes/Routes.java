package com.example.api_gateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Value("${player.service.url}")
    private String playerServiceUrl;


    @Value("${participant.service.url}")
    private String participantServiceUrl;

    @Value("${session.service.url}")
    private String sessionServiceUrl;

    @Bean
    public RouterFunction<ServerResponse> playerServiceRoute() {
        return GatewayRouterFunctions.route("player_service")
                .route(RequestPredicates.path("/api/player/**"), HandlerFunctions.http(playerServiceUrl))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> SessionServiceRoute() {
        return GatewayRouterFunctions.route("session_service")
                .route(RequestPredicates.path("/api/session/**"), HandlerFunctions.http(sessionServiceUrl))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> participantServiceRoute() {
        return GatewayRouterFunctions.route("participant_service")
                .route(RequestPredicates.path("/api/participant"), HandlerFunctions.http(participantServiceUrl))
                .build();
    }

}
