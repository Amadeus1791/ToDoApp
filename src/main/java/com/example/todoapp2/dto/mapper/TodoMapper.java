package com.example.todoapp2.dto.mapper;

import com.example.todoapp2.dto.TodoDto;
import com.example.todoapp2.model.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public TodoDto mapToDto(Todo todo) {
        TodoDto todoDto = new TodoDto(todo.getId(), todo.getTitle(), todo.isDone());
        return todoDto;
    }

    public Todo mapToTodo(TodoDto dto) {
        Todo todo = new Todo(dto.getId(), dto.getTitle(), dto.isDone());
        return todo;
    }
 }
