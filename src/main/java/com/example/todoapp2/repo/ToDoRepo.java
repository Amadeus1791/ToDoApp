package com.example.todoapp2.repo;

import com.example.todoapp2.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<Todo, Long> {

}
