# Todo MCP Server

Simple Spring Boot Java application exposing a Todo REST API and a set of MCP tools for use with MCP Inspector.

## Overview

- Language: Java 
- Purpose: Manage todo items via REST and expose MCP tools to interact with the service programmatically.
- MCP tools available:
    - `find_todo_by_id` — Finds a todo item by its ID.
    - `create_todo` — Creates a new todo item (accepts a `CreateTodoRequest`).
    - `get_all_todos` — Retrieves all todo items.
    - `delete_todo` — Deletes a todo item by its ID.

## Requirements

- JDK 17+ (or configured project JDK)
- Maven
- MCP Inspector (for testing MCP tools)

## Build & Run

From the project root:

- Run directly:
    - `mvn spring-boot:run`


## REST Endpoints

- GET `/todos` — list all todos
- GET `/todos/{id}` — get todo by id
- POST `/todos` — create todo (JSON body)
- DELETE `/todos/{id}` — delete todo by id

## MCP Inspector — testing the MCP tools

1. Start the application (see Build & Run).
2. run the mcp Inspector directly through `npx @modelcontextprotocol/inspector`
3. Open MCP Inspector and connect to your MCP agent/environment.

