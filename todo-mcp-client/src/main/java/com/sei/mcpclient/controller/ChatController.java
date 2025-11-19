package com.sei.mcpclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder, ToolCallbackProvider tools) {
        Arrays.stream(tools.getToolCallbacks())
                .forEach(t -> logger.info("Tool callback found : {} ", t.getToolDefinition()));
        this.chatClient = builder
                .defaultToolCallbacks(tools)
                .build();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        logger.info(message);
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
