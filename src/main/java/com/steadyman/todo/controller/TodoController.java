package com.steadyman.todo.controller;

import com.steadyman.todo.dto.Todo;
import com.steadyman.todo.repository.TodoRepository;
import com.steadyman.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class TodoController {

    private final TodoService todoService;
    private final TodoRepository todoRepository;

    public TodoController(TodoService todoService,
                          TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public String health() {
        return "OK";
    }

    @GetMapping("/todo")
    public List<Todo> list() {
        return todoRepository.findAll().stream()
                .map(Todo::from)
                .collect(Collectors.toList());
    }

    @PostMapping("/todo")
    public Todo register(@RequestBody @Valid Todo todo) {
        log.info("memberSeq = {}, content = {}", todo.getMemberSeq(), todo.getContent());
        return todoService.registerTodo(todo);
    }

    @PutMapping("/todo")
    public Todo edit(@RequestBody @Valid Todo todo) {
        log.info("id = {}, memberSeq = {}, content = {}", todo.getId(), todo.getMemberSeq(), todo.getContent());
        return todoService.editTodo(todo);
    }

}
