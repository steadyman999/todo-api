package com.steadyman.todo.controller;

import com.steadyman.todo.dto.Todo;
import com.steadyman.todo.entity.TodoEntity;
import com.steadyman.todo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
        return todoRepository.findAll().stream()
                .map(Todo::from)
                .collect(Collectors.toList());
    }

    @PostMapping("/todo")
    public Todo register(@RequestBody @Valid Todo todo) {
        log.info("memberSeq = {}, content = {}", todo.getMemberSeq(), todo.getContent());
        TodoEntity entity = TodoEntity.of(todo.getMemberSeq(), todo.getContent());
        return Todo.from(todoRepository.save(entity));
    }

}
