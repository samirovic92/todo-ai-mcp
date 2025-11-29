package com.sei.mcpserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.security.server.apikey.ApiKeyEntityRepository;
import org.springaicommunity.mcp.security.server.apikey.memory.ApiKeyEntityImpl;
import org.springaicommunity.mcp.security.server.apikey.memory.InMemoryApiKeyEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import static org.springaicommunity.mcp.security.server.config.McpApiKeyConfigurer.mcpServerApiKey;

@Slf4j
@EnableWebSecurity
@Configuration
public class McpServerConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("Mcp Server Configuration securityFilterChain");
        return http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().authenticated()
                )
                .with(
                        mcpServerApiKey(),
                        (apiKey) ->apiKey.apiKeyRepository(apiKeyRepository())
                )
                .build();
    }

    private ApiKeyEntityRepository<ApiKeyEntityImpl> apiKeyRepository() {
        var apiKey = ApiKeyEntityImpl.builder()
                .name("mcp server api key")
                .id("api-01")
                .secret("return new InMemoryApiKeyEntityRepository<>(List.of(apiKey));")
                .build();
        return new InMemoryApiKeyEntityRepository<>(List.of(apiKey));
    }
}
