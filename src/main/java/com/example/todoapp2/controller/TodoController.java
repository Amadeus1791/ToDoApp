package com.example.todoapp2.controller;

import com.example.todoapp2.dto.TodoDto;
import com.example.todoapp2.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/todo")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todo) {
        return new ResponseEntity<>(service.addTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> allTodos = service.getAllTodos();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id) {
        TodoDto todo = service.getTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updatedTodo = service.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        service.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted successfully!.");
    }


}
