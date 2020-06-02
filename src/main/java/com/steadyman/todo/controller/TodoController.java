package com.steadyman.todo.controller;

import com.steadyman.todo.entity.Todo;
import com.steadyman.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public String health() {
        return "OK";
    }

    @GetMapping("/todo")
    public List<Todo> list() {
        return todoRepository.findAll();
    }

}
