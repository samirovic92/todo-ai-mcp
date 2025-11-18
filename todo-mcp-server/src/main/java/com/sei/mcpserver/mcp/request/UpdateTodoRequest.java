package com.sei.mcpserver.mcp.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTodoRequest {
    private String title;
    private String description;
    private boolean completed;
}
