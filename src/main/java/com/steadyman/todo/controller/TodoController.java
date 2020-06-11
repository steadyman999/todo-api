package com.steadyman.todo.controller;

import com.steadyman.todo.dto.Todo;
import com.steadyman.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public String health() {
        return "OK";
    }

    @GetMapping("/todo")
    public List<Todo> list() {
        return todoService.getList();
    }

    @GetMapping("/todo/{id}")
    public Todo detail(@PathVariable Long id) {
        return todoService.get(id);
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

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

}
