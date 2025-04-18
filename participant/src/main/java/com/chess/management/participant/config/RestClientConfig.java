package com.chess.management.participant.config;


import com.chess.management.participant.client.PlayerClient;
import com.chess.management.participant.client.SessionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

    @Value("${player.service.url}")
    private String playerServiceUrl;

    @Value("${session.service.url}")
    private String sessionServiceUrl;


    @Bean
    public PlayerClient playerClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(playerServiceUrl)
                .requestFactory(clientHttpRequestFactory())
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(PlayerClient.class);
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(Duration.ofSeconds(3));
        clientHttpRequestFactory.setReadTimeout(Duration.ofSeconds(3));
        return clientHttpRequestFactory;
    }

    @Bean
    public SessionClient sessionClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(sessionServiceUrl)
                .requestFactory(clientHttpRequestFactory())
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(SessionClient.class);
    }
}
