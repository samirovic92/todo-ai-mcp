package com.sei.mcpserver.mcp;


import com.sei.mcpserver.mcp.request.CreateTodoRequest;
import com.sei.mcpserver.mcp.response.TodoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TodoMcpTools {
    private final RestTemplate restTemplate;
    private final Integer port;
    private final String baseUrl;

    public TodoMcpTools(RestTemplate restTemplate,
                        @Value("${todo-service.port}") Integer port) {
        this.restTemplate = restTemplate;
        this.port = port;
        this.baseUrl =  String.format("http://localhost:%s", port);
    }

    @McpTool(name = "find_todo_by_id", description = "Finds a todo item by its ID.")
    public TodoResponse findTodoById(Long id) {
        log.info("Getting todo with id {}", id);
        var url = String.format("%s/todos/%s", baseUrl, id);
        return restTemplate.getForObject(url, TodoResponse.class);
    }

    @McpTool(name = "create_todo", description = "Creates a new todo item with the given title and description.")
    public TodoResponse createTodo(CreateTodoRequest todo) {
        log.info("Creating todo {}", todo);
        var url = String.format("%s/todos", baseUrl);
        return restTemplate.postForObject(url, todo, TodoResponse.class);
    }

    @McpTool(name = "get_all_todos", description = "Retrieves all todo items.")
    public TodoResponse[] getAllTodos() {
        log.info("Getting all todos");
        var url = String.format("%s/todos", baseUrl);
        return restTemplate.getForObject(url, TodoResponse[].class);
    }

    @McpTool(name = "delete_todo", description = "Deletes a todo item by its ID.")
    public void deleteTodo(Long id) {
        log.info("Deleting todo with id {}", id);
        var url = String.format("%s/todos/%s", baseUrl, id);
        restTemplate.delete(url);
    }
}
