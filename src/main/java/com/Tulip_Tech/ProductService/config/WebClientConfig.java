package com.Tulip_Tech.ProductService.config;


import com.Tulip_Tech.ProductService.exception.custom.ProductCustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Configuration


public class WebClientConfig {

    @Value("${order.service.url}")
    private String orderServiceUrl;

    @Bean
    public WebClient orderWebClient(WebClient.Builder builder) {
        return builder.baseUrl(orderServiceUrl).filter(errorDecoderFilter()).build();
    }

    private ExchangeFilterFunction errorDecoderFilter() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            if (clientResponse.statusCode().isError()) {
                return clientResponse.bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {
                }).flatMap(body -> Mono.error(new ProductCustomException(body.toString(), HttpStatus.BAD_REQUEST)));
            }
            return Mono.just(clientResponse);
        });
    }
}
