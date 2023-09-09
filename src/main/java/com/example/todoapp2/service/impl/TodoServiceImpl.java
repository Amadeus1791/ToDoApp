package com.example.todoapp2.service.impl;

import com.example.todoapp2.dto.TodoDto;
import com.example.todoapp2.dto.mapper.TodoMapper;
import com.example.todoapp2.model.Todo;
import com.example.todoapp2.repo.ToDoRepo;
import com.example.todoapp2.service.TodoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    ToDoRepo toDoRepo;

    @Autowired
    TodoMapper mapper;


    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // map
        Todo todo = mapper.mapToTodo(todoDto);
        toDoRepo.save(todo);
        return todoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Optional<Todo> foundByID = toDoRepo.findById(id);
        if (foundByID.isPresent()) {
            return mapper.mapToDto(foundByID.get());
        } else {
            throw new IllegalArgumentException("Todo with the id: " + id + "not found");
        }

    }

    @Override
    public List<TodoDto> getAllTodos() {
        return toDoRepo.findAll().stream().map(todo -> mapper.mapToDto(todo)).toList();
    }

    @Override
    public TodoDto updateTodo(TodoDto todo, Long id) {
        try {
            TodoDto foundByID = getTodo(id);
            foundByID.setDone(todo.isDone());
            foundByID.setTitle(todo.getTitle());
            return addTodo(foundByID);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("You cannot update a todo which does not exist");
        }
    }

    @Override
    public void deleteTodo(Long id) {
        Optional<Todo> foundbyId = toDoRepo.findById(id);
        if (foundbyId.isEmpty()) {
            throw new IllegalArgumentException("You cannot delete a non existent Todo");
        }
        toDoRepo.delete(foundbyId.get());
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Optional<Todo> foundByID = toDoRepo.findById(id);
        if (foundByID.isEmpty()) {
            throw new IllegalArgumentException("You cannot delete a non existent Todo");
        }
        Todo todo = foundByID.get();
        todo.setDone(true);
        toDoRepo.save(todo);
        return mapper.mapToDto(todo);
    }

    @PostConstruct
    void init() {
        TodoDto todo1 = new TodoDto(1L, "my first todo", false);
        TodoDto todo2 = new TodoDto(2L, "my second todo", true);
        addTodo(todo1);
        addTodo(todo2);

    }
}
