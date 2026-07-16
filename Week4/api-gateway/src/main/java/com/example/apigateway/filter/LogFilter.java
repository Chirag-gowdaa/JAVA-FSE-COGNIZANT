package com.example.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

/**
 * Global Log Filter in API Gateway that intercepts all incoming requests
 * and prints detailed logs including HTTP Method, URI, Request ID, and Timestamp.
 */
@Component
public class LogFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Retrieve request details
        String method = exchange.getRequest().getMethod().name();
        String uri = exchange.getRequest().getURI().toString();
        String requestId = exchange.getRequest().getId();
        LocalDateTime timestamp = LocalDateTime.now();

        // Print details to console logs
        logger.info("==========================================");
        logger.info("API Gateway LogFilter - Incoming Request");
        logger.info("HTTP Method: {}", method);
        logger.info("Request URI: {}", uri);
        logger.info("Request ID : {}", requestId);
        logger.info("Timestamp  : {}", timestamp);
        logger.info("==========================================");

        // Continue filter chain execution
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // High precedence to log requests as early as possible
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
