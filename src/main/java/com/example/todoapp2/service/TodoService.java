package com.example.todoapp2.service;

import com.example.todoapp2.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todo);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todo, Long id);

    void deleteTodo(Long id);

    TodoDto completeTodo(Long id);


}
